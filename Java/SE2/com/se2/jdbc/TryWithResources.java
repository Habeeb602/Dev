package com.se2.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TryWithResources {

    public static void main(String[] args) {

        // Read bank table and print the rows

        List<BankAccount> bankAccounts = new ArrayList<>();

        /**
         * Try(with Resources) can have multiple resources inside the parenthesis
         * It automatically closes the resources in the reverse order.
         * Hence, we don't have any need to close it separately in finally block.
         */

        try(
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "user123");
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Bank");
                ResultSet rs = ps.executeQuery()
                ) {

            while(rs.next()){

                bankAccounts.add(
                        new BankAccount(
                                rs.getString("account"),
                                rs.getString("name"),
                                rs.getDouble("balance")
                        )
                );

            }

            System.out.println("Bank Accounts: ");
            for(BankAccount account: bankAccounts){
                System.out.println(account);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
