package com.acme.testing;

import com.acme.util.MyDate;

public class passByExperiment {

    public static void main(String[] args){
        MyDate d = new MyDate(9,30,1999);
        int i = 10;
        String date = "30/09/1999";

        passByExperiment.passByObject(d);
        passByExperiment.passByPrimitive(i);
        passByExperiment.passByString(date);

        System.out.println();

        System.out.println("Pass by Object(outside method): " + d);
        System.out.println("Pass by Primitive(outside method): " + i);
        System.out.println("Pass by String(outside method): " + date);
    }



    static void passByObject(MyDate d){
        d.year = 2012;
        System.out.println("Pass by Object(inside method): " + d);
    }

    static void passByPrimitive(int i){
        i = 2012;
        System.out.println("Pass by Primitive(inside method): " + i);
    }

    static void passByString(String date){
        int k = date.lastIndexOf('/');
        String newDate = date.substring(0, k+1);
        newDate += "2012";
        System.out.println("Pass by String(inside method): " + newDate);
    }



}
