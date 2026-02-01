package com.acme.domain;
import com.acme.util.MyDate;

public class Order {
    MyDate date;
    double orderAmount;
    int size;
    public static double taxRate;
    String customer;
    Product product;

    private static Rushable rushable;

    static{
        taxRate = 0.05;
    }

    public Order(){}

    public Order(MyDate date, double orderAmount, Product product, String customer, int size){
        this.setOrderDate(date);
//        this.date = date;
        this.orderAmount = orderAmount;
        this.product = product;
        this.customer = customer;
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public char jobSize(){
        if(size <= 25){
            return 'S';
        }
        else if(size > 25 && size <=75){
            return 'M';
        }
        else if(size > 75 && size <= 150){
            return 'L';
        }
        else{
            return 'X';
        }
    }

    public double computeTotal(){
        double discount = 0, total;
        switch (jobSize()){
            case 'S':
                discount = 0;
                break;
            case 'M':
                discount = orderAmount * 0.01;
                break;
            case 'L':
                discount = orderAmount * 0.02;
                break;
            case 'X':
                discount = orderAmount * 0.03;
                break;
        }

        total = orderAmount - discount + computeTax();
        return total;
    }

    public static void setTaxRate(double taxRate){
        Order.taxRate = taxRate;
    }

    public static void computeTaxOn(double orderAmount){
        System.out.println("The Tax for " + orderAmount + " is: " + taxRate*orderAmount);
    }

    public double computeTax(){
        System.out.println("The Tax for this order is: " + taxRate*this.orderAmount);
        return taxRate*this.orderAmount;
    }

    public static void setRushable(Rushable rushable){
        Order.rushable = rushable;
    }

    public static Rushable getRushable(){
        return Order.rushable;
    }

    public boolean isPriorityOrder(){
        boolean priorityOrder = false;
        if(rushable != null){
            priorityOrder =  rushable.isRushable(this.date, this.orderAmount);
        }
        return priorityOrder;
    }

    private static boolean isHoliday(MyDate date){
        MyDate[] holidays = date.getHolidays();
        for(int i=0;i<holidays.length;i++){
            if(date.equals(holidays[i])){
               return true;
            }
        }
        return false;
    }

    private void setOrderDate(MyDate date){
        if(isHoliday(date)){
            System.out.println("Sorry, " + date + " is a holiday, we don't like to work on holidays :)");
        }
        else{
            this.date = date;
        }
    }

    @Override
    public String toString(){
        return size + " ea. " + customer + " for " + product;
    }
}

