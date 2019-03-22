package com.akushwah.example.democors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.akushwah.example.democors.domain.Person;

@Service
public class PersonService {
   public List<Person> getAllPerson() {
	   List<Person> list = new ArrayList<>();
	   list.add(new Person(1, "Mahesh"));
	   list.add(new Person(2, "Ram"));
	   list.add(new Person(3, "Krishna"));
	   return list;
   }
}
