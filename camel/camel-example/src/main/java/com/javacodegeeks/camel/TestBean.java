package com.javacodegeeks.camel;


public class TestBean {
	public String hello(String msg) {
		return msg + ":" + Thread.currentThread();
	}
}
