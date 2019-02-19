package com.sample.boot;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.SAXException;

import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.AdditionalInformationWire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.BusinessInformation;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.CustomerCreditTransferInitiationV08Wire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.DateWire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.Document;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.ExternalLocalInstrument1CodeWire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.GroupHeader48;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.LocalInstrument2Wire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.Pain00100108Wire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.PartyIdentification43;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.PaymentInstruction22Wire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.PaymentMethod3CodeWire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.PaymentTypeInformation19Wire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.SupplementaryData1Wire;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.SupplementaryDataEnvelope1Wire;

public class MyUtils {

	public static final String JSON_MARKER = "{";

	public static FormatType detectMessageFormat(byte[] bytes) {
		// try {
		// String text = IOUtils.toString(is, StandardCharsets.UTF_8.name());
		// System.out.println(text);
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		byte[] myBytes = Arrays.copyOf(bytes, JSON_MARKER.length());
		String cont = new String(myBytes, 0, JSON_MARKER.length());
		System.out.println("Detecting Message Format: " + cont);
		return cont.startsWith(JSON_MARKER) ? FormatType.JSON : null;
	}

	public static <T> T parseAndValidate(InputStream inputStream, Class<T> jaxbModelClass) throws JAXBException {
		try {
			Source source = new StreamSource(new BufferedInputStream(inputStream));
			Unmarshaller unmarshaller = getJAXBContext(jaxbModelClass).createUnmarshaller();

			return unmarshaller.unmarshal(source, jaxbModelClass).getValue();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static <T> T parseAndValidate(String str, Class<T> jaxbModelClass) throws JAXBException {
		try {
			System.out.println("parsing " + str);
			Source source = new StreamSource(new StringReader(str));
			Unmarshaller unmarshaller = getJAXBContext(jaxbModelClass).createUnmarshaller();

			return (T) unmarshaller.unmarshal(new StringReader(str));
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static Document parseAndValidatePain(String str) throws JAXBException {
		try {
			System.out.println("parsing " + str);
			JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setSchema(getSchema("pain.001.001.08.wire.xsd"));
			unmarshaller.setEventHandler(new XsdValidationEventHandler());
			Document result = (Document) unmarshaller.unmarshal(new StringReader(str));
			return result;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static Map<String, Schema> schemaMap = new HashMap<>();
	private static SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	private static Schema getSchema(String xsdPath) {
		return schemaMap.computeIfAbsent(xsdPath, k -> {
			try {
				schemaMap.put(xsdPath, schemaFactory.newSchema(new File(xsdPath)));
				return schemaMap.get(xsdPath);
			} catch (SAXException e) {
				throw new ExceptionInInitializerError(e);
			}
		});
	}

	private static Map<Class, JAXBContext> jaxbContextMap = new HashMap<>();

	private static JAXBContext getJAXBContext(Class jaxbModelClass) {
		return jaxbContextMap.computeIfAbsent(jaxbModelClass, k -> {
			try {
				jaxbContextMap.put(jaxbModelClass, JAXBContext.newInstance(jaxbModelClass));
				return jaxbContextMap.get(jaxbModelClass);
			} catch (JAXBException e) {
				System.err.println("JAXBContext is not initialized.");
				throw new ExceptionInInitializerError(e);
			}
		});
	}

	public static Document convert(InputStream stream) {
		Document pain00100108Wire = null;
		String xml = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			int read = 0;
			byte[] buff = new byte[1024];
			while ((read = stream.read(buff)) != -1) {
				bos.write(buff, 0, read);
			}
			byte[] bytes = bos.toByteArray();
			String str = new String(bytes);
			JSONObject json = new JSONObject(str);
			xml = XML.toString(json);
			System.out.println("1");
			System.out.println(xml);
			String root = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document xmlns=\"urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:pts2:wire:iso:20022:tech:xsd:pain.001.001.08:V06 pain.001.001.08.wire.xsd\">";

			StringBuffer buffer = new StringBuffer();
			buffer.append(root);
			System.out.println("2");
			System.out.println(xml);

			xml = modifyByCapitalizing(xml);
			System.out.println("3");
			System.out.println(xml);

			buffer.append(xml);
			buffer.append("</Document>");

			pain00100108Wire = parseAndValidatePain(buffer.toString());
		} catch (IOException | JSONException | JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (pain00100108Wire == null) {
			System.out.println("Error Error Error");
			pain00100108Wire = createSampleDoc();
		} else {
			System.out.println("OK OK OK");
		}
		return pain00100108Wire;
	}
	
	public static XMLGregorianCalendar convertStringToCalender(String dateTimeStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");
		Date date;
		XMLGregorianCalendar xmlGregCal = null;
		try {
			date = format.parse(dateTimeStr);
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);

			xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xmlGregCal;
	}

	public static String modifyByCapitalizing(String text) {
		Matcher m = Pattern.compile("<[a-z]|</[a-z]").matcher(text);

		StringBuilder sb = new StringBuilder();
		int last = 0;
		while (m.find()) {
			sb.append(text.substring(last, m.start()));
			sb.append(m.group(0).toUpperCase());
			last = m.end();
		}
		sb.append(text.substring(last));
		return sb.toString();
	}

	public static void main(String[] args) throws JSONException {
		String jsonStr = "{\"Customer\": {" + "\"address\": {" + "\"street\": \"NANTERRE CT\"," + "\"postcode\": 77471"
				+ "}," + "\"name\": \"Mary\"," + "\"age\": 37" + "}}";

		JSONObject json = new JSONObject(jsonStr);
		String xml = XML.toString(json);

		System.out.println(xml);
	}

	public static Pain00100108Wire createSampleDoc() {
		Pain00100108Wire p = new Pain00100108Wire();
		CustomerCreditTransferInitiationV08Wire cstmrCdtTrfInitn = new CustomerCreditTransferInitiationV08Wire();

		GroupHeader48 grpHdr = new GroupHeader48();
		grpHdr.setMsgId("0000001234560300419");

		grpHdr.setNbOfTxs("1");
		PartyIdentification43 initgPty = new PartyIdentification43();
		initgPty.setNm("PENTAGON FEDERAL CREDIT UNION");
		grpHdr.setInitgPty(initgPty);

		cstmrCdtTrfInitn.setGrpHdr(grpHdr);

		SupplementaryData1Wire splmData = new SupplementaryData1Wire();
		SupplementaryDataEnvelope1Wire dataEnvelope1Wire = new SupplementaryDataEnvelope1Wire();
		AdditionalInformationWire addtlnf = new AdditionalInformationWire();
		BusinessInformation businessInformation = new BusinessInformation();
		businessInformation.setChanlCd("INB");
		addtlnf.setBizInf(businessInformation);
		dataEnvelope1Wire.setAddtlInf(addtlnf);
		splmData.setEnvlp(dataEnvelope1Wire);

		cstmrCdtTrfInitn.getSplmtryDatas().add(splmData);

		PaymentInstruction22Wire pmtInf = new PaymentInstruction22Wire();
		pmtInf.setPmtInfId("000000123456789213");
		pmtInf.setPmtMtd(PaymentMethod3CodeWire.TRF);
		PaymentTypeInformation19Wire pmtTpInf = new PaymentTypeInformation19Wire();
		LocalInstrument2Wire localInstrument2Wire = new LocalInstrument2Wire();
		localInstrument2Wire.setCd(ExternalLocalInstrument1CodeWire.DRC);
		pmtTpInf.setLclInstrm(localInstrument2Wire);
		pmtInf.setPmtTpInf(pmtTpInf);
		DateWire dateWire = new DateWire();
		pmtInf.setReqdExctnDt(dateWire);
		pmtInf.setInstrForDbtrAgt("Instruction");

		cstmrCdtTrfInitn.setPmtInf(pmtInf);
		p.setCstmrCdtTrfInitn(cstmrCdtTrfInitn);
		return p;
	}

	/**
	 * XSD Schema validation error handler
	 */
	private static class XsdValidationEventHandler implements ValidationEventHandler {

		@Override
		public boolean handleEvent(ValidationEvent event) {
			if (event.getSeverity() == ValidationEvent.ERROR || event.getSeverity() == ValidationEvent.FATAL_ERROR) {
				return false;
			}

			return true;
		}
	}
}
