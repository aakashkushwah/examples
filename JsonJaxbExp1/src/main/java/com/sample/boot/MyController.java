package com.sample.boot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.Document;
import com.cft.pts.payment.processing.integration.iso20022.model.wire.pain00100108.Pain00100108Wire;
import com.example.ak.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MyController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private MyData myData = new MyData();
	
	public MyController() {
		
	}
	
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Inside init");
		myData.setRoot(AkUtils.readAndCreateContent());
	}
	
	public Root getRoot() {
		return myData.getRoot();
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println(getRoot().getFirstElement()+" , "+getRoot().getSecondElement());
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/postgreeting")
	public Greeting greeting(@RequestBody Greeting greeting) {
		greeting.setContent("By Aakash");
		return greeting;
	}

	@RequestMapping("/getdoc")
	public Pain00100108Wire getDoc() {
		return MyUtils.createSampleDoc();
	}

	@RequestMapping("/postdoc")
	public Document postDoc(@RequestBody Document document) {
		document.getCstmrCdtTrfInitn().getPmtInf().setInstrForDbtrAgt("Reverse Instrument");
		return document;
	}

	@RequestMapping("/convert")
	public Document convertTest(InputStream stream) {
		return MyUtils.convert(stream);
	}

	@RequestMapping("/postdoc3")
	public Pain00100108Wire postDoc3(InputStream stream) {
		Pain00100108Wire result = null;
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
				Pain00100108Wire doc = objectMapper.readValue(bytes, Pain00100108Wire.class);
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
			result = MyUtils.createSampleDoc();
			result.getCstmrCdtTrfInitn().getPmtInf().setInstrForDbtrAgt("Reverse Instrument AK");
		}
		return result;
	}

	@RequestMapping("/postdoc2")
	public Pain00100108Wire postDoc2(InputStream stream) {
		System.out.println("Aakash Kushwah Received");
		System.out.println("Hi");
		Pain00100108Wire result = null;
		try {
			result = MyUtils.parseAndValidate(stream, Pain00100108Wire.class);
			// // Create a JaxBContext
			// JAXBContext jc = JAXBContext.newInstance(Document.class);
			//
			// // Create the Unmarshaller Object using the JaxB Context
			// Unmarshaller unmarshaller = jc.createUnmarshaller();
			//
			// // Set the Unmarshaller media type to JSON or XML
			// unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,
			// "application/json");
			//
			// // Set it to true if you need to include the JSON root element in the
			// // JSON input
			// unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
			//
			// // Create the StreamSource by creating StringReader using the JSON input
			// StreamSource json = new StreamSource(stream);
			//
			// // Getting the employee pojo again from the json
			// CustomerCreditTransferInitiationV08Wire wire = unmarshaller
			// .unmarshal(json, CustomerCreditTransferInitiationV08Wire.class).getValue();
			//
			// if (wire != null) {
			// result = new Pain00100108Wire();
			// result.setCstmrCdtTrfInitn(wire);
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == null) {
			System.out.println("Aakash Kushwah");
			result = MyUtils.createSampleDoc();
		} else {
			System.out.println("Aakash Kushwah No Error");
		}
		return result;
	}

	
}
