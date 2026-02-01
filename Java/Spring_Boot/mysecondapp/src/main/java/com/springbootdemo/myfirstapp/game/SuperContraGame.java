package com.springbootdemo.myfirstapp.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier ("SuperContraGameQuali")
public class SuperContraGame implements GamingConsole{

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Contra Going up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Contra Going down");
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		System.out.println("Contra Going back");
	}

	@Override
	public void acclerate() {
		// TODO Auto-generated method stub
		System.out.println("Contra Going front");
	}

}
