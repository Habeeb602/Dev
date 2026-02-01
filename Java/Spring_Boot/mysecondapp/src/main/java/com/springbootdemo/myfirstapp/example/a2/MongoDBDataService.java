package com.springbootdemo.myfirstapp.example.a2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier ("MongoDB")
public class MongoDBDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {10,20,30};
	}
	
}
