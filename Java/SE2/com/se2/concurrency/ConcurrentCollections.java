package com.se2.concurrency;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollections {

    public static void main(String[] args) {

        ConcurrentCollections concurrentCollections = new ConcurrentCollections();

//        concurrentCollections.concurrentHashMap();
//        concurrentCollections.concurrentSkipList();
//        concurrentCollections.copyOnWrite();
        concurrentCollections.blockingQueues();
    }

    public void concurrentHashMap(){
        /***
        Map<String, String> capitalWithCountries = new HashMap<>();

        capitalWithCountries.put("New Delhi", "India");
        capitalWithCountries.put("Colombo", "Sri Lanka");
        capitalWithCountries.put("Bangladesh", "Dhaka");

        for(Map.Entry<String, String> entry: capitalWithCountries.entrySet()){
            System.out.println(entry.getKey() + " is the capital of " + entry.getValue());

            --- Throws Concurrent Modification Exception
            capitalWithCountries.remove(entry.getKey());
        }

         */

        Map<String, String> capitalWithCountries = new ConcurrentHashMap<>();

        capitalWithCountries.put("New Delhi", "India");
        capitalWithCountries.put("Colombo", "Sri Lanka");
        capitalWithCountries.put("Bangladesh", "Dhaka");

        for(Map.Entry<String, String> entry: capitalWithCountries.entrySet()){
            System.out.println(entry.getKey() + " is the capital of " + entry.getValue());
            capitalWithCountries.remove(entry.getKey());
        }

        System.out.println("capitalWithCountries = " + capitalWithCountries);
    }

    private void concurrentSkipList(){

        /**
         * Concurrent Skip List is an ordered collection - means it stores data in sorted order
         * Concurrent operations are allowed in these collections*/

        Set<String> countries = new ConcurrentSkipListSet<>();

        countries.add("New Zealand");
        countries.add("Kenya");
        countries.add("Argentina");

        System.out.println("Concurrent Skip List Set: ");
        countries.forEach(System.out::println);

        Map<String, Integer> people = new ConcurrentSkipListMap<>();

        people.put("Habeeb", 23);
        people.put("Adam", 12);
        people.put("Evan", 37);

        System.out.println("Concurrent Skip List Map: ");
        people.forEach((name, age) -> System.out.println(name + " " + age));
    }

    private void copyOnWrite(){

        /**
         * CopyOnWrite Lists and Sets are effective at retrieving the data
         * But, whenever we add/remove items from this collection
         * This creates a whole new collection i.e. copy of the collection and add/ removes the element in that collection
         * So, it is not a good idea to use this collection, if frequent add/remove operations are required*/

        List<String> names = new CopyOnWriteArrayList<>();

        names.add("Alan");
        names.add("Tesla");
        names.add("Bohr");

        /**
         * It takes a copy of the list as an iterator
         * So, whenever we add an element into the list, it has no effect on the iterator
         * So, it doesn't result in infinite loop
         * */
        System.out.println("CopyOnWriteList: ");
        for(String name: names){
            System.out.println(name);
            names.add(name);
        }
        System.out.println("names = " + names);


        Set<String> namesSet = new CopyOnWriteArraySet<>();

        namesSet.add("Alan");
        namesSet.add("Tesla");
        namesSet.add("Bohr");

        /**
         * Since Set doesn't allow duplication, we are adding a last name to make a unique name during iteration*/
        String lastName = "Watson";
        System.out.println("CopyOnWriteSet: ");
        for(String name: namesSet){
            System.out.println(name);
            namesSet.add(name + " " + lastName);
        }

        System.out.println("namesSet = " + namesSet);
    }

    private void blockingQueues(){

        Queue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        concurrentLinkedQueue.offer("Red");
        concurrentLinkedQueue.offer("Blue");
        concurrentLinkedQueue.offer("Green");

        System.out.println("concurrentLinkedQueue.element() = " + concurrentLinkedQueue.element());
        System.out.println("concurrentLinkedQueue.peek() = " + concurrentLinkedQueue.peek());
        System.out.println("concurrentLinkedQueue = " + concurrentLinkedQueue);
        System.out.println("concurrentLinkedQueue.poll() = " + concurrentLinkedQueue.poll());
        System.out.println("concurrentLinkedQueue (after Poll) = " + concurrentLinkedQueue);


        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

        try{
            linkedBlockingQueue.offer("Yellow", 400, TimeUnit.MILLISECONDS);
            linkedBlockingQueue.offer("White", 400, TimeUnit.MILLISECONDS);
            linkedBlockingQueue.offer("Pink", 400, TimeUnit.MILLISECONDS);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("linkedBlockingQueue.element() = " + linkedBlockingQueue.element());
        System.out.println("linkedBlockingQueue.peek() = " + linkedBlockingQueue.peek());
        System.out.println("linkedBlockingQueue = " + linkedBlockingQueue);
        System.out.println("linkedBlockingQueue.poll() = " + linkedBlockingQueue.poll());
        System.out.println("linkedBlockingQueue (after Poll) = " + linkedBlockingQueue);


    }


}
