package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "9876543210");

        greetCustomer(customer);
        greetCustomerConsumer.accept(customer);
        greetCustomerBiConsumer.accept(customer, true);
        greetCustomerBiConsumer.accept(customer, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hi " + customer.name + ", Thanks for registering your number: " + customer.phone);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber)  ->
            System.out.println("Hi " + customer.name + ", Thanks for registering your number: " + (showPhoneNumber ? customer.phone: "************"));


    static void greetCustomer(Customer customer){
        System.out.println("Hi " + customer.name + ", Thanks for registering your number: " + customer.phone);
    }


    static class Customer{
        String name;
        String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}


