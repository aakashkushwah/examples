package com.ddlab.dozer.type3;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ddlab.dozer.type2.destnpkg.AddressBean;
import com.ddlab.dozer.type2.srcpkg.Address;

/**
 * The Class TestBidirectional is used as test class for bi-directional bean
 * copy.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class TestBidirectional {

	/**
	 * One way.
	 * 
	 * @param mapper
	 *            the mapper
	 */
	public static void oneWay(Mapper mapper) {

		Address adrs = new Address();// Source
		adrs.setId(11);
		adrs.setName("name1");

		AddressBean adb = new AddressBean();// Destination
		mapper.map(adrs, adb);
		System.out.println(adb.getId());
		System.out.println(adb.getName());

	}

	/**
	 * Bidirectional.
	 * 
	 * @param mapper
	 *            the mapper
	 */
	public static void bidirectional(Mapper mapper) {

		Address adrs = new Address();// Destination

		AddressBean adb = new AddressBean();// Source
		adb.setId(333);
		adb.setName("Bidirectional");

		mapper.map(adb, adrs);
		System.out.println(adrs.getId());
		System.out.println(adrs.getName());

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("dozerBidirectionalMapping1.xml");
		Mapper mapper = new DozerBeanMapper(list);
		oneWay(mapper);
		bidirectional(mapper);
	}

}
