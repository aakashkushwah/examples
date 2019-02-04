package com.sample.pain.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.example.CstmrCdtTrfInitn;
import com.example.PmtInf;
import com.sample.pain.Document;

public class TestPainBeanMapping3 {

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
		list.add("dozerpainmapping2.xml");
		// Add to DozerMapper
		Mapper mapper = new DozerBeanMapper(list);
		com.example.Document p1 = new com.example.Document();// Destination Object
		CstmrCdtTrfInitn cstmrCdtTrfInitn = new CstmrCdtTrfInitn();
		PmtInf pmtInf = new PmtInf();
		pmtInf.setInstrForDbtrAgt("IR");
		pmtInf.setPmtMtd("TRF");
		cstmrCdtTrfInitn.setPmtInf(pmtInf);
		p1.setCstmrCdtTrfInitn(cstmrCdtTrfInitn);
		
		Document p = new Document();
		mapper.map(p1, p, "a1");
		System.out.println("IR : " + p.getCstmrCdtTrfInitn().getPmtInf().getInstrForDbtrAgt());
		System.out.println("pmtmtd : " + p.getCstmrCdtTrfInitn().getPmtInf().getPmtMtd());

	}

}
