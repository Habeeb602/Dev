package com.se2.io.nio2;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream(new File("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\prep\\message.properties"));

        properties.load(fis);

        System.out.println("properties.getProperty(\"key1\") = " + properties.getProperty("key1"));
        System.out.println("properties.getProperty(\"key2\", \"Good Night\") = " + properties.getProperty("key2", "Good Night"));
        System.out.println("properties.getProperty(\"key3\", \"Good Afternoon\") = " + properties.getProperty("key3", "Good Afternoon"));
        System.out.println("properties.getProperty(\"key4\") = " + properties.getProperty("key4"));

    }
}
