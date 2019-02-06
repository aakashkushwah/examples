package com.sample.boot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.pain.AdditionalInformationWire;
import com.sample.pain.BusinessInformation;
import com.sample.pain.CustomerCreditTransferInitiationV08Wire;
import com.sample.pain.DateWire;
import com.sample.pain.Document;
import com.sample.pain.ExternalLocalInstrument1CodeWire;
import com.sample.pain.GroupHeader48;
import com.sample.pain.LocalInstrument2Wire;
import com.sample.pain.PartyIdentification43;
import com.sample.pain.PaymentInstruction22Wire;
import com.sample.pain.PaymentMethod3CodeWire;
import com.sample.pain.PaymentTypeInformation19Wire;
import com.sample.pain.SupplementaryData1Wire;
import com.sample.pain.SupplementaryDataEnvelope1Wire;

@RestController
public class MyController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/postgreeting")
	public Greeting greeting(@RequestBody Greeting greeting) {
		greeting.setContent("By Aakash");
		return greeting;
	}

	@RequestMapping("/getdoc")
	public Document getDoc() {
		return MyController.createSampleDoc();
	}

	@RequestMapping("/postdoc")
	public Document postDoc(@RequestBody Document document) {
		document.getCstmrCdtTrfInitn().getPmtInf().setInstrForDbtrAgt("Reverse Instrument");
		return document;
	}

	@RequestMapping("/postdoc3")
	public Document postDoc3(InputStream stream) {
		Document result = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			int read = 0;
			byte[] buff = new byte[1024];
			while ((read = stream.read(buff)) != -1) {
			    bos.write(buff, 0, read);
			}
			byte[] bytes = bos.toByteArray();
			FormatType formatType = MyUtils.detectMessageFormat(bytes);

			if (FormatType.JSON == formatType) {
				ObjectMapper objectMapper = new ObjectMapper();
				Document doc = objectMapper.readValue(bytes, Document.class);
				if (doc != null) {
					result = doc;
					result.getCstmrCdtTrfInitn().getPmtInf().setInstrForDbtrAgt("Reverse Instrument");
				}
			} else {
				System.out.println("FormatType detected: " + formatType);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (result == null) {
			result = MyController.createSampleDoc();
			result.getCstmrCdtTrfInitn().getPmtInf().setInstrForDbtrAgt("Reverse Instrument AK");
		}
		return result;
	}

	@RequestMapping("/postdoc2")
	public Document postDoc2(InputStream stream) {
		System.out.println("Aakash Kushwah Received");
		Document result = null;
		try {
			// Create a JaxBContext
			JAXBContext jc = JAXBContext.newInstance(Document.class);

			// Create the Unmarshaller Object using the JaxB Context
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			// Set the Unmarshaller media type to JSON or XML
			unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");

			// Set it to true if you need to include the JSON root element in the
			// JSON input
			unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

			// Create the StreamSource by creating StringReader using the JSON input
			StreamSource json = new StreamSource(stream);

			// Getting the employee pojo again from the json
			CustomerCreditTransferInitiationV08Wire wire = unmarshaller
					.unmarshal(json, CustomerCreditTransferInitiationV08Wire.class).getValue();

			if (wire != null) {
				result = new Document();
				result.setCstmrCdtTrfInitn(wire);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == null) {
			System.out.println("Aakash Kushwah");
			result = MyController.createSampleDoc();
		} else {
			System.out.println("Aakash Kushwah No Error");
		}
		return result;
	}

	public static Document createSampleDoc() {
		Document p = new Document();
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

		cstmrCdtTrfInitn.getSplmtryData().add(splmData);

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
}
