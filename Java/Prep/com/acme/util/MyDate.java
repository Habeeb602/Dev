package com.acme.util;

import java.time.LocalDate;

public class MyDate{

    public int month, day, year;
    static MyDate[] holidays;

    static{
        holidays = new MyDate[5];

        for(int i=0;i< holidays.length;i++){
            LocalDate today = LocalDate.now().plusDays(i);
            holidays[i] = new MyDate(today.getMonthValue(), today.getDayOfMonth(), today.getYear());
        }
    }

    public MyDate(){}

    public MyDate(int month, int day, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(int month, int day, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static void leapYears(){
        int i;
        for(i=1752;i<=2020;i++){
            if((i%4 == 0 && i%100 !=0) || (i%4 == 0 && i%400 == 0)){
                System.out.println("The year " + i + " is a leap year");
            }
        }
    }

    public MyDate[] getHolidays(){
        return holidays;
    }

    public static void listHolidays(){
        for(int i =0;i<holidays.length;i++){
            System.out.println(holidays[i]);
        }
    }

    @Override
    public String toString(){
        return this.day + "-" + this.month + "-" + this.year;
    }

    @Override
    public boolean equals(Object obj){

        if(obj instanceof MyDate myDate) {

            return this.year == myDate.year && this.month == myDate.month && this.day == myDate.day;
        }
        return false;
    }

}
