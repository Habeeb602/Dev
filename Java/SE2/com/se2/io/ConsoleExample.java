package com.se2.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleExample {

    /**
     *
     * Run the file in terminal
     * java -cp "C:\Program Files\Java\jdk1.8.0_333\bin\javac.exe" .\ConsoleExample.java
     */

    public static void main(String[] args) {

        Console console = System.console();

        if(console == null){
            System.err.println("Console isn't available");
        }
        else{
            String name = console.readLine("Please enter your %s: ", "name");
            console.printf("Hello %s%n", name);
            console.printf("Welcome!");
            console.writer().println();

            char[] pwd = console.readPassword("Enter password (between %d to %d): ", 6, 10);
            char[] repPwd = console.readPassword("Enter password again: ");

            boolean match = Arrays.equals(pwd, repPwd);

            if(match){
                console.printf("Passwords match!");
            }
            else{
                console.printf("Passwords do not match!");
            }


        }


    }
}
