package com.learnspringboot.restwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learnspringboot.restwebservices.classes.SomeBean;

@RestController
@RequestMapping("/filtering")
public class FilteringController {

	
	@GetMapping("/")
	public SomeBean getData() {
		return new SomeBean("Text1", "Text2", "Text3");
	}
	
	@GetMapping("/list")
	public List<SomeBean> getListData(){
		return Arrays.asList(new SomeBean("Text1", "Text2", "Text3"), new SomeBean("Text4", "Text5", "Text6"));
	}
	
	@GetMapping("/dynamic")
	public MappingJacksonValue getDynamicFilteredData() {
		SomeBean someBean = new SomeBean("Value-1", "Value-2", "Value-3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		// The filter name should be added in the Bean class
		// with @JsonFilter()
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
	
	@GetMapping("/dynamic/list")
	public MappingJacksonValue getDynamicFilteredListData() {
		
		List<SomeBean> list = Arrays.asList(new SomeBean("Text1", "Text2", "Text3"), new SomeBean("Text4", "Text5", "Text6"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanListFilter", filter );
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
}
