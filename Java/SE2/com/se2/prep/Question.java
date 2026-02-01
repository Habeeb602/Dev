package com.se2.prep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Question {

    private static void checkLength(String s) throws IllegalArgumentException, RuntimeException, Exception{
        if(s.length() == 0){
            throw new IllegalArgumentException("Length should be greater than 0");
        }

    }

    public static void main(String[] args) {

        try{
            checkLength("");
        }
        catch(IllegalArgumentException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}