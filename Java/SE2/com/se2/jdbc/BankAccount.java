package com.se2.jdbc;

public class BankAccount {
    private String account;
    private String name;
    private double balance;

    public BankAccount(String account, String name, double balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    public BankAccount() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
