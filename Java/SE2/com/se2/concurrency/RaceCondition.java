package com.se2.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceCondition implements Runnable {

    private BankAccount account = new BankAccount(50);
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        RaceCondition rc1 = new RaceCondition();
        RaceCondition rc2 = new RaceCondition();

        Thread john = new Thread(rc1);
        Thread mary = new Thread(rc1);

        john.setName("John");
        mary.setName("Mary");

        john.start();
        mary.start();

    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            makeWithdrawal(10);
//            makeWithdrawalWithLock(10);
            if(account.getBalance() < 0){
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Account Over-Drawn");
                sleep500ms();
            }
        }
    }

    public synchronized void makeWithdrawal(int amount){
        if(account.getBalance() >= amount){
            System.out.println("Thread: " + Thread.currentThread().getName() + ", Before Withdrawal: " + account.getBalance());
            account.withdraw(10);
            System.out.println("Thread: " + Thread.currentThread().getName() + ", After Withdrawal: " + account.getBalance());
            sleep500ms();
        }
        else{
            System.out.println(Thread.currentThread().getName() + " unable to withdraw, Before Withdrawal: " + account.getBalance());
        }
    }

    public void makeWithdrawalWithLock(int amount){

        try{
            lock.lock();

            if(account.getBalance() >= amount){
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Before withdrawal: " + account.getBalance());
                account.withdraw(amount);
                System.out.println("Thread: " + Thread.currentThread().getName() + ", After withdrawal: " + account.getBalance());
                sleep500ms();
            }
            else{
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Insufficient amount: " + account.getBalance());
            }
        }
        finally {
            lock.unlock();
        }
    }



    public void sleep500ms(){
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}


class BankAccount{
    private int balance;

    public BankAccount() {
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
