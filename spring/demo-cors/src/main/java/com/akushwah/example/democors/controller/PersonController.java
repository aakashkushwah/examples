package com.akushwah.example.democors.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akushwah.example.democors.domain.Person;
import com.akushwah.example.democors.service.PersonService;

@RestController
@RequestMapping("/info")
public class PersonController {
	@Autowired
	private PersonService service;

	@RequestMapping("/home")
	@CrossOrigin(exposedHeaders = { "sahil" })
	public List<Person> showData(HttpServletResponse httpResponse) {
		List<Person> list = service.getAllPerson();
		httpResponse.setHeader("Aakash1", "6400");
		return list;
	}
	
	@RequestMapping("/get")
	@CrossOrigin(exposedHeaders = { "nothing" })
	public List<Person> hello(HttpServletResponse httpResponse) {
		List<Person> list = service.getAllPerson();
//		httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8085");
//        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        httpResponse.setHeader("Access-Control-Allow-Headers", "X-Auth-Token, Content-Type");
//        httpResponse.setHeader("Access-Control-Expose-Headers", "custom-header1, custom-header2");
//        httpResponse.setHeader("Access-Control-Allow-Credentials", "false");
//        httpResponse.setHeader("Access-Control-Max-Age", "4800");
		httpResponse.setHeader("Aakash2", "4800");
		return list;
	}
}
