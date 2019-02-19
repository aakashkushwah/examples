package com.sample.boot;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;

public class ParseXmlStringDemo {
	public static void main(String[] args) {
		try {
			String xml = "<Employee><firstName>Yashwant</firstName><lastName>Chavan</lastName></Employee>";
			JAXBContext jc = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new StringReader(xml));
			JAXBElement<Employee> je = unmarshaller.unmarshal(streamSource, Employee.class);

			Employee employee = (Employee) je.getValue();
			System.out.println("First Name:- " + employee.getFirstName());
			System.out.println("Last Name:- " + employee.getLastName());
			String key = "DRB|DRC"; 
				
			String[] spl = StringUtils.split(key, '|');
			for (String string : spl) {
				System.out.println(string);
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
