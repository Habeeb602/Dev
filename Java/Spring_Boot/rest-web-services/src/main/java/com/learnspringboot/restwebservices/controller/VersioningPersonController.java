package com.learnspringboot.restwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.restwebservices.classes.PersonV1;
import com.learnspringboot.restwebservices.classes.PersonV2;
import com.learnspringboot.restwebservices.classes.Name;

@RestController
public class VersioningPersonController {
	
	
	// Versioning using URL
	@GetMapping(path="/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Robbery Bob");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Robbery", "Bob"));
	}
	
	
	// Versioning using Request Parameters(aka query parameters)
	@GetMapping(path="person", params="version=1")
	public PersonV1 getPersonV1RequestParams(){
		return new PersonV1("Robbery Bob");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getPersonV2RequestParams() {
		return new PersonV2(new Name("Robbery", "Bob"));
	}
	
	
	// Versioning using Reauest Headers
	@GetMapping(path="/person", headers="X-API-VERSION=1")
	public PersonV1 getPersonV1RequestHeader(){
		return new PersonV1("Robbery Bob");
	}
	
	@GetMapping(path="/person", headers="X-API-VERSION=2")
	public PersonV2 getPersonV2RequestHeader(){
		return new PersonV2(new Name("Robbery","Bob"));
	}
	
	
	// Versioning using Accept Headers (aka Media Type Versioning)
	@GetMapping(path="/person", produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonV1AcceptHeader() {
		return new PersonV1("Robbery Bob");
	}
	
	@GetMapping(path="/person", produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonV2AcceptHeader() {
		return new PersonV2(new Name("Robbery", "Bob"));
	}
	
	
}
