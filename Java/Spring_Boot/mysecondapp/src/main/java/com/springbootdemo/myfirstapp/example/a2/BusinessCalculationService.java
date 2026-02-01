package com.springbootdemo.myfirstapp.example.a2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	
	DataService dService;
	public BusinessCalculationService(@Qualifier ("MongoDB") DataService dService) {
//		super();
		this.dService = dService;
	}
	
	
	public int findMax() {
		return Arrays.stream(dService.retrieveData()).max().orElse(0);
	}
	
}
