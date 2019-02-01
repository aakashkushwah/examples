package com.sample.pain.mapping;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ddlab.rnd.type1.destnpkg.Person1;
import com.ddlab.rnd.type1.srcpkg.Address;
import com.ddlab.rnd.type1.srcpkg.Person;
import com.sample.pain.CustomerCreditTransferInitiationV08Wire;
import com.sample.pain.Document;
import com.sample.pain.PaymentInstruction22Wire;

public class TestPainBeanMapping {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		// Add the mapping configuration
		list.add("dozerMapping.xml");
		// Add to DozerMapper
		Mapper mapper = new DozerBeanMapper(list);
		// Form the source object
		Document document = new Document();
		CustomerCreditTransferInitiationV08Wire customerCreditTransferInitiationV08Wire = new CustomerCreditTransferInitiationV08Wire();
		PaymentInstruction22Wire paymentInstruction22Wire = new PaymentInstruction22Wire();
		paymentInstruction22Wire.setInstrForDbtrAgt("Instruction");
		customerCreditTransferInitiationV08Wire.setPmtInf(paymentInstruction22Wire);
		document.setCstmrCdtTrfInitn(customerCreditTransferInitiationV08Wire);
		
		Person1 p1 = new Person1();// Destination Object
		// Copy the bean from source to destination
//		mapper.map(p, p1, "a");
		// Check the destination bean
		System.out.println("Age : " + p1.getAge1());
		System.out.println("Door No : " + p1.getAdrs1().getDoorNo1());
		System.out.println("Street Name : " + p1.getAdrs1().getStName1());

	}

}
