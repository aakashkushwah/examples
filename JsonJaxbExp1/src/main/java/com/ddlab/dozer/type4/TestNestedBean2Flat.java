package com.ddlab.dozer.type4;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ddlab.dozer.type4.destnpkg.Address1;
import com.ddlab.dozer.type4.destnpkg.Person1;
import com.ddlab.dozer.type4.srcpkg.MyPerson;

/**
 * The Class TestNestedBean2Flat is used as test class to copy the object having
 * nested object to object of type flat structure.
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra</a>
 * @since 2013
 */
public class TestNestedBean2Flat {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("nestedBeanMapping2Flat.xml");

		Mapper mapper = new DozerBeanMapper(list);

		Address1 adrs1 = new Address1();
		adrs1.setDoorNo1(123);
		adrs1.setStName1("my Nmae");

		Person1 p1 = new Person1();
		p1.setAdrs1(adrs1);
		p1.setAge1(13);
		p1.setName1("saaa");

		MyPerson p = new MyPerson();
		mapper.map(p1, p, "b");

		System.out.println(p.getAge());
		System.out.println(p.getDoorNo());
		System.out.println(p.getName());
		System.out.println(p.getStName());

	}

}
