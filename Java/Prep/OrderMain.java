public class OrderMain {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 20, 2008);
        Order anvil = new Order(date1, 2000.00, "Wile E Coyote", "Anvil", 10);
        MyDate date2 = new MyDate(4, 10, 2008);
        Order balloons = new Order(date2, 1000.00, "Bugs Bunny", "Balloon", 125);
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
    }
}


class Order {
    MyDate date;
    double orderAmount;
    int someInt;
    static double taxRate;
    String product, customer;

    static{
        taxRate = 0.05;
    }

    Order(){}

    Order(MyDate date, double orderAmount, String product, String customer, int someInt){
        this.date = date;
        this.orderAmount = orderAmount;
        this.product = product;
        this.customer = customer;
        this.someInt = someInt;
    }

    static void setTaxRate(double taxRate){
        Order.taxRate = taxRate;
    }

    static void computeTaxOn(double orderAmount){
        System.out.println("The Tax for " + orderAmount + " is: " + taxRate*orderAmount);
    }

    double computeTax(){
        System.out.println("The Tax for this order is: " + taxRate*this.orderAmount);
        return taxRate*this.orderAmount;
    }


    @Override
    public String toString(){
        return someInt + " ea. " + customer + " for " + product;
    }
}
