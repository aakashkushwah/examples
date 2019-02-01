/**
 * 
 */
package com.sample.pain;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

/**
 * @author ashraf_sarhan
 * 
 */
public class UnmarshallerDemo {

	/**
	 * @param args
	 * @throws JAXBException
	 *             Unmarshaller JSON to POJO using EclipseLink MOXy
	 */
	public static void main(String[] args) throws JAXBException {

		// Create a JaxBContext
		JAXBContext jc = JAXBContext.newInstance(Document.class);

		// Create the Unmarshaller Object using the JaxB Context
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		// Set the Unmarshaller media type to JSON or XML
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,
				"application/json");

		// Set it to true if you need to include the JSON root element in the
		// JSON input
		unmarshaller
				.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

		// Create the StreamSource by creating StringReader using the JSON input
		StreamSource json = new StreamSource(
				new StringReader(
						"{\"CstmrCdtTrfInitn\":{\"PmtInf\":{\"InstrForDbtrAgt\":\"Instruction\"}}}"));

		// Getting the employee pojo again from the json
		CustomerCreditTransferInitiationV08Wire document = unmarshaller.unmarshal(json, CustomerCreditTransferInitiationV08Wire.class)
				.getValue();

		// Print the employee data to console
		System.out.println("Instructor For Debtor Agent: " + document.getPmtInf().getInstrForDbtrAgt());
	}

}
