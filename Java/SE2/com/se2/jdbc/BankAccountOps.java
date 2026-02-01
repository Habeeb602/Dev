package com.se2.jdbc;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountOps {

    private Connection connection;

    public BankAccountOps(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "user123");
            System.out.println("DB Connected!");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BankAccountOps bankOps = new BankAccountOps();

        // Select by AccountID
//        BankAccount bankAccount = bankOps.getBankAccountById("12245");
//        System.out.println(bankAccount);

        // Select All Rows
//        List<BankAccount> bankAccounts = bankOps.selectBankAccounts();
//        System.out.println(bankAccounts);


        // Delete by AccountID

//        String  accountId = "66778";
//        List<BankAccount> bankAccounts = bankOps.selectBankAccounts();
//        System.out.println("Before Deleting Account: " + accountId);
//        for(BankAccount account: bankAccounts){
//            System.out.println(account);
//        }
//        System.out.println();
//        int nRows = bankOps.deleteAccountById("88776");
//        System.out.println("Number of rows deleted: " + nRows);
//        System.out.println();
//        bankAccounts = bankOps.selectBankAccounts();
//        System.out.println("After Deleting Account: " + accountId);
//        for(BankAccount account: bankAccounts) {
//            System.out.println(account);
//        }


        // Delete all accounts
//        System.out.println("Deleting all the accounts");
//        System.out.println("Number of rows deleted: " + bankOps.deleteAllAccounts());

        // Insert new account

//        int nRows = bankOps.insertAccount(new BankAccount("33445", "Sumaiya", 40000.44));
//        System.out.println("Number of rows affected: " + nRows);
//        List<BankAccount> bankAccounts = bankOps.selectBankAccounts();
//        for(BankAccount account: bankAccounts){
//            System.out.println(account);
//        }


        // Update an account

        int nRows = bankOps.updateAccount("88776", new BankAccount("", "Nasirah", 60000));
        System.out.println("Number of rows affected: " + nRows);
        List<BankAccount> bankAccounts = bankOps.selectBankAccounts();
        for(BankAccount account: bankAccounts){
            System.out.println(account);
        }





    }

    private BankAccount getBankAccountById(String accountId){

        String selectQuery = "SELECT * FROM Bank WHERE account = ?";
        BankAccount bankAccount = null;

        try(PreparedStatement ps = connection.prepareStatement(selectQuery)){

            ps.setString(1, accountId);
            ResultSet rs =  ps.executeQuery();
            if(!rs.next()){
                return bankAccount;
            }


            bankAccount = new BankAccount(
                    rs.getString("account"),
                    rs.getString("name"),
                    rs.getDouble("balance")
                    );

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return bankAccount;
    }

    private List<BankAccount> selectBankAccounts(){

        String selectAllSQL = "SELECT * FROM Bank";
        List<BankAccount> bankAccounts = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(selectAllSQL)){

            boolean isResultSet = ps.execute();

            if(isResultSet){
                ResultSet rs = ps.getResultSet();
                while(rs.next()){
                    bankAccounts.add(
                    new BankAccount(
                            rs.getString("account"),
                            rs.getString("name"),
                            rs.getDouble("balance"))
                    );
                }
            }
            else{
                System.out.println("Didn't execute select statement");
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return bankAccounts;
    }

    private int deleteAccountById(String accountId){

        String deleteSql = "DELETE FROM Bank WHERE account = ?";
        int nRows = -1;
        try(PreparedStatement ps = connection.prepareStatement(deleteSql)){
            ps.setString(1, accountId);
            nRows = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return nRows;
    }

    private int deleteAllAccounts(){
        String deleteSql = "DELETE FROM Bank";
        int nRows = -1;
        try(PreparedStatement ps = connection.prepareStatement(deleteSql)){

            nRows = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return nRows;
    }

    private int insertAccount(BankAccount bankAccount){
        String insertSql = "INSERT INTO Bank VALUES (?,?,?)";

        int nRows = -1;

        try(PreparedStatement ps = connection.prepareStatement(insertSql)){
            ps.setString(1, bankAccount.getAccount());
            ps.setString(2, bankAccount.getName());
            ps.setDouble(3, bankAccount.getBalance());

            nRows = ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return nRows;
    }

    private int updateAccount(String accountId, BankAccount bankAccount){

        String updateSql = "UPDATE Bank SET name = ?, balance = ? WHERE account = ?";
        int nRows = -1;
        try(PreparedStatement ps = connection.prepareStatement(updateSql)){

            ps.setString(1, bankAccount.getName());
            ps.setDouble(2, bankAccount.getBalance());
            ps.setString(3, accountId);

            nRows = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return nRows;
    }

}
