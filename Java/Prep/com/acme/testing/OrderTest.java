package com.acme.testing;
import com.acme.domain.Good;
import com.acme.domain.Solid;
import com.acme.util.MyDate;
import com.acme.domain.Order;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 20, 2008);
        Solid product_1 = new Solid("Acme Anvil", 1668, 0.3f, Good.UnitOfMeasure.CUBIC_METER, false, 500, 0.25, 0.3);
        Order anvil = new Order(date1, 2000.00, product_1,"Wile E Coyote" , 10);
        MyDate date2 = new MyDate(07, 29, 2023);
        Solid product_2 = new Solid("Acme Balloon", 1401, 15, Good.UnitOfMeasure.CUBIC_FEET, false, 10, 5, 5);
        Order balloons = new Order(date2, 1000.00, product_2,"Bugs Bunny", 125);
        System.out.println(anvil);
        System.out.println(balloons);
        System.out.println("The tax Rate is currently: " +
                Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvil.computeTax();
        balloons.computeTax();
        Order.setTaxRate(0.06);
        System.out.println("The tax Rate is currently: " +
                Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvil.computeTax();
        balloons.computeTax();

        System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
        System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

        /*
        Order.setRushable((orderDate, amount) -> {
            LocalDate orderLocalDate = LocalDate.of(orderDate.year, orderDate.month, orderDate.day);
//            System.out.println(orderLocalDate.isAfter());
            System.out.println(LocalDate.now().plusMonths(1));

            return true;
        });
         */
        System.out.println("Is " + anvil.getProduct().getName() + " a priority order? " +anvil.isPriorityOrder());
        System.out.println("Is " + balloons.getProduct().getName() + " a priority order? " +balloons.isPriorityOrder());
        LocalDate.of(2015, 8, 5).getDayOfWeek();
    }
}