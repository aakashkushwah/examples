package com.sample.boot;

import java.util.Arrays;

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
}
