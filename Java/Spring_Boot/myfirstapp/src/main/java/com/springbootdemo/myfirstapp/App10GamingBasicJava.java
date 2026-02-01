package com.springbootdemo.myfirstapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springbootdemo.myfirstapp.game.GameRunner;
import com.springbootdemo.myfirstapp.game.MarioGame;
import com.springbootdemo.myfirstapp.game.SuperContraGame;
import com.springbootdemo.myfirstapp.game.GamingConsole;
import com.springbootdemo.myfirstapp.game.PacmanGame;



public class App10GamingBasicJava {
    public static void main(String args[]){
    	
    	
//        var  = new MarioGame();
//        GamingConsole game = new MarioGame();
        var game = new PacmanGame();
        
        // GameRunner has the dependency, which is GamingConsole
        // Without it, GameRunner cannot run by itself
        // The place where we are adding the dependency is called "Injecting Dependency"
        var gameRunner = new GameRunner(game);
        gameRunner.run();
        
       
    	
    	
    }
}
