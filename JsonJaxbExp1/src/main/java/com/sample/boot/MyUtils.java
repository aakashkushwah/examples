package com.sample.boot;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class MyUtils {
	
	public static final String JSON_MARKER = "{";
	
    public static FormatType detectMessageFormat(byte[] bytes) {
//    	try {
//			String text = IOUtils.toString(is, StandardCharsets.UTF_8.name());
//			System.out.println(text);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
    	
    	byte[] myBytes = Arrays.copyOf(bytes, JSON_MARKER.length());
        String cont = new String(myBytes, 0, JSON_MARKER.length());
        System.out.println("Detecting Message Format: "+cont);
        return cont.startsWith(JSON_MARKER) ? FormatType.JSON : null;
    }
    
    
    public static <T> T parseAndValidate(InputStream inputStream, Class<T> jaxbModelClass) throws JAXBException {
        try {
            Source source = new StreamSource(new BufferedInputStream(inputStream));
            Unmarshaller unmarshaller = getJAXBContext(jaxbModelClass).createUnmarshaller();

            return unmarshaller.unmarshal(source, jaxbModelClass).getValue();
        } catch(JAXBException e) {
        	e.printStackTrace();
            throw e;
        }
    }
    private static Map<Class, JAXBContext> jaxbContextMap  = new HashMap<>();
    
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
}
