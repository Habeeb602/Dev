package com.springbootdemo.myfirstapp.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {
	
	public void up() {
		System.out.println("Mario Going up");
	}
	
	public void down() {
		System.out.println("Mario Going down");
	}
	
	public void back() {
		System.out.println("Mario Going back");
	}
	
	public void acclerate() {
		System.out.println("Mario Going front");
	}
	
}
