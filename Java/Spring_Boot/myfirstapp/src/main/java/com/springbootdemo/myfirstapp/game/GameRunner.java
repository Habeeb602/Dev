package com.springbootdemo.myfirstapp.game;

public class GameRunner {

	GamingConsole game;
	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("Running: " + game);
		game.up();
		game.down();
		game.acclerate();
		game.back();
		
	}

}
