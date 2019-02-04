package com.sample.pain.mapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.eclipse.persistence.jaxb.MarshallerProperties;

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

public class GeneratePainJson {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws JAXBException 
	 * @throws DatatypeConfigurationException 
	 */
	public static void main(String[] args) throws JAXBException, DatatypeConfigurationException {
		List<String> list = new ArrayList<String>();
		// Add the mapping configuration
		list.add("dozerpainmapping.xml");
		// Add to DozerMapper
		Mapper mapper = new DozerBeanMapper(list);
		// Form the source object
		Document p = new Document();
		CustomerCreditTransferInitiationV08Wire cstmrCdtTrfInitn = new CustomerCreditTransferInitiationV08Wire();
		
		GroupHeader48 grpHdr= new GroupHeader48();
		grpHdr.setMsgId("0000001234560300419");

		GregorianCalendar c = new GregorianCalendar();
		Instant instant = Instant.now(); 
		c.setTime(Date.from(instant));
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		grpHdr.setCreDtTm(date);
		grpHdr.setNbOfTxs("1");
		PartyIdentification43 initgPty = new PartyIdentification43();
		initgPty.setNm("PENTAGON FEDERAL CREDIT UNION");
		grpHdr.setInitgPty(initgPty);
		
		cstmrCdtTrfInitn.setGrpHdr(grpHdr);
		
		SupplementaryData1Wire splmData = new SupplementaryData1Wire();
		SupplementaryDataEnvelope1Wire dataEnvelope1Wire = new SupplementaryDataEnvelope1Wire();
		AdditionalInformationWire addtlnf = new AdditionalInformationWire();
		BusinessInformation businessInformation =  new BusinessInformation();
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
		dateWire.setDt(date);
		pmtInf.setReqdExctnDt(dateWire);
		pmtInf.setInstrForDbtrAgt("Instruction");
		
		
		cstmrCdtTrfInitn.setPmtInf(pmtInf);
		p.setCstmrCdtTrfInitn(cstmrCdtTrfInitn);
		// Create a JaxBContext
		JAXBContext jc = JAXBContext.newInstance(CustomerCreditTransferInitiationV08Wire.class);

		// Create the Marshaller Object using the JaxB Context
		Marshaller marshaller = jc.createMarshaller();

		// Set the Marshaller media type to JSON or XML
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the JSON
		// output
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

		// Set it to true if you need the JSON output to formatted
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshal the employee object to JSON and print the output to console
		
		marshaller.marshal(p, System.out);
	}

}
