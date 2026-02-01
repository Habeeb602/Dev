package com.se2.locale;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatExample {

    public static void main(String[] args) {

        NumberFormatExample numberFormatExample = new NumberFormatExample();

//        numberFormatExample.formatNumbers();
//        numberFormatExample.formatCurrencies();
//        numberFormatExample.parseNumbers();
        numberFormatExample.customFormat();
    }

    private void formatNumbers(){

        double number = 77000.02;

        System.out.println("NumberFormat.getInstance().format(number) = " + NumberFormat.getInstance().format(number));
        System.out.println("NumberFormat.getInstance(Locale.UK).format(number) = " + NumberFormat.getInstance(Locale.UK).format(number));
        System.out.println("NumberFormat.getInstance(Locale.ITALY).format(number) = " + NumberFormat.getInstance(Locale.ITALY).format(number));
        System.out.println("NumberFormat.getInstance(Locale.FRANCE).format(number) = " + NumberFormat.getInstance(Locale.FRANCE).format(number));
    }

    private void formatCurrencies(){
        double money = 65.25;

        System.out.println("NumberFormat.getCurrencyInstance().format(money) = " + NumberFormat.getCurrencyInstance().format(money));
        System.out.println("NumberFormat.getCurrencyInstance(Locale.UK).format(money) = " + NumberFormat.getCurrencyInstance(Locale.UK).format(money));
        System.out.println("NumberFormat.getCurrencyInstance(Locale.US).format(money) = " + NumberFormat.getCurrencyInstance(Locale.US).format(money));
        System.out.println("NumberFormat.getCurrencyInstance(Locale.ITALY).format(money) = " + NumberFormat.getCurrencyInstance(Locale.ITALY).format(money));

        System.out.println();

        Locale[] locales = new Locale[]{Locale.getDefault(), Locale.UK, Locale.US, Locale.ITALY};
        String[] currencies = new String[locales.length];

        for (int i = 0; i < locales.length; i++) {
            currencies[i] = NumberFormat.getCurrencyInstance(locales[i]).format(money);
        }

        System.out.print("Locales Array: ");
        for (Locale locale : locales) {
            System.out.print(locale + " ");
        }

        System.out.println();

        System.out.print("String Currencies: ");
        for(String currency: currencies){
            System.out.print(currency + " ");
        }

        System.out.println("\n");

        System.out.println("Parsing String currencies to numbers: ");
        for(int i = 0;i< locales.length;i++){
            try{
                System.out.println("NumberFormat.getCurrencyInstance(" + locales[i] + ").parse(" + currencies[i] + ") = " + NumberFormat.getCurrencyInstance(locales[i]).parse(currencies[i]));
            }
            catch (ParseException e){
                e.printStackTrace();
            }
        }

    }

    private void parseNumbers() {
        String number = "25,000.51";
        try{
            System.out.println("NumberFormat.getInstance(Locale.US).parse(number) = " + NumberFormat.getInstance(Locale.US).parse(number));
            System.out.println("NumberFormat.getInstance(Locale.UK).parse(number) = " + NumberFormat.getInstance(Locale.UK).parse(number));
            System.out.println("NumberFormat.getInstance(Locale.CHINESE).parse(number) = " + NumberFormat.getInstance(Locale.CHINESE).parse(number));
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    private void customFormat(){

        double num = 25000.81;

        System.out.println("new DecimalFormat(\"#,##,##,###.##\").format(" + num + ") = " + new DecimalFormat("#,##,##,###.##").format(num));
        System.out.println("new DecimalFormat(\"00,00,000.00\").format(" + num +") = " + new DecimalFormat("00,00,000.00").format(num));
    }


}
