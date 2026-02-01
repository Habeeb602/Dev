package com.springbootdemo.myfirstapp.game;

public class PacmanGame implements GamingConsole{

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("Pacman Going up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Pacman Going down");
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		System.out.println("Pacman Going back");
	}

	@Override
	public void acclerate() {
		// TODO Auto-generated method stub
		System.out.println("Pacman Going front");
	}

}
