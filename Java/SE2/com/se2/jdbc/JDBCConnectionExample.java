package com.se2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnectionExample {


    /**
     * Navigate to this java file location and run this command, to execute the file
     * java -cp "C:\Users\003WJ4744\Downloads\mysql-connector-j-8.1.0\mysql-connector-j-8.1.0\mysql-connector-j-8.1.0.jar" JDBCConnectionExample.java
     *
     * NOT REQUIRED, We can add the driver jar dependency by going to
     * File -> Project Structure -> Dependencies Tab -> Click '+' -> Browse Driver JAR file -> Click apply
     */

    public static void main(String[] args) {
        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "user123");
            System.out.println("DB Connected!");

            String createSql = "CREATE TABLE Bank (account VARCHAR(10) PRIMARY KEY, name VARCHAR(20), balance bigint);";

            try (PreparedStatement ps = connection.prepareStatement(createSql)){
                System.out.println(ps);
                /**
                 * ps.execute() returns true, if we ran a select query or insert statement.
                 * returns false for other sql statements.
                */
                System.out.println("ps.execute() = " + ps.execute());
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
