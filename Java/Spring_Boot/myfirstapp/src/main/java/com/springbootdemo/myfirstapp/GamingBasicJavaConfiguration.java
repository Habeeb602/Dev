package com.springbootdemo.myfirstapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springbootdemo.myfirstapp.game.*;

@Configuration
public class GamingBasicJavaConfiguration {
	
	@Bean
	@Primary // Making marioGame primary
	public GamingConsole marioGame() {
		return new MarioGame();
	}
	
	@Bean
	public GamingConsole pacmanGame() {
		return new PacmanGame();
	}
	
	@Bean
	public GamingConsole superContraGame() {
		return new SuperContraGame();
	}
	
	@Bean
	// Auto-Wiring marioGame
	public GameRunner gameRunner(GamingConsole pacmanGame) {
		return new GameRunner(pacmanGame);
	}
}
