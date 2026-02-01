package com.springbootdemo.myfirstapp.example.a2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySqlDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {11,30,40};
	}
	
}
