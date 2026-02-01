package com.se2.collection;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {

        ListExample listExample = new ListExample();

//        listExample.factoryMethods();
//        listExample.arrayList();
//        listExample.stack();
        listExample.listTest();
    }

    private void listTest(){
        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();
        int size = 0;
        int key, value;
        while(true){
            System.out.print("Enter 1.get, 2.add, 3.show: ");
            int ch = sc.nextInt();

            if(ch == 1){
                System.out.print("Enter key: ");
                key = sc.nextInt();
                if(list.contains(key)){
                    System.out.println(key + ": " + map.get(key));
                    list.remove(Integer.valueOf(key));
                    list.offerFirst(key);
                }
                else{
                    System.out.println(-1);
                }

            }
            else if(ch == 2){
                System.out.print("Enter key: ");
                key = sc.nextInt();
                System.out.print("Enter value: ");
                value = sc.nextInt();
                if(list.size() < capacity){
                    if(list.contains(key)){
                        list.remove(Integer.valueOf(key));
                    }

                }
                else{
                    if(list.contains(key)){
                        list.remove(Integer.valueOf(key));
                    }
                    else{
                        list.pollLast();
                    }

                }
                list.offerFirst(key);
                map.put(key, value);
            }
            else if (ch == 3) {
                System.out.println("list = " + list);
                System.out.println("map = " + map);
            } else{
                break;
            }
        }
    }

    private void factoryMethods(){

        String[] arr = new String[]{"Alpha", "Beta", "Gamma", "Delta"};
        /** Ways to create a list */
        List<String> arrList = Arrays.asList(arr);
        List<String> ofList = List.of("Omega", "PI", "Sigma");
        List<String> copyList = List.copyOf(ofList);

        System.out.print("String array: ");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("arrList = " + arrList);
        System.out.println("ofList = " + ofList);
        System.out.println("copyList = " + copyList);


        /** Change in String array reflects in the arraylist(which created through the array) and vice-versa
         *
         */
        arr[1] = "Theta";
        System.out.println("arrList (changes made in array reflected in arraylist) = " + arrList);


        arrList.set(0, "Kota");
        System.out.print("String array (change made in arraylist reflected in array): ");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();


        /**
         * The List created through Arrays.asList(), List.of(), List.copyOf() are not-alterable
         * we cannot add anything to those lists*/

//        arrList.add("Hi");
    }

    private void arrayList(){
        List<String> names = new ArrayList<>(Arrays.asList("Alan", "Alan", "Mary", "Mary", "John"));

        System.out.println("names = " + names);

        names.add(1, "Sean");
        System.out.println("names (after adding 'Sean' at index 1) = " + names);

        names.remove("Alan");
        System.out.println("names (after removing 'Alan' using remove()) = " + names);

        names.set(0, "Ben");
        System.out.println("names (after replacing( set() ) 'Ben' at index '0') = " + names);

        names.removeIf(name -> name.startsWith("M"));
        System.out.println("names (after removeIf(name -> name.startsWith(\"M\"))) = " + names);

        names.replaceAll(name -> name + " Watts");
        System.out.println("names (after replacing names with 'name' + ' Watts') = " + names);
    }

    private void stack(){
        Stack<String> stack = new Stack<>();

        stack.push("Coffee");
        stack.push("Ice Cream");
        stack.push("Lemonade");

        System.out.println("stack = " + stack);
        System.out.println("stack.peek() = " + stack.peek());
        stack.pop();
        System.out.println("stack (after pop()) = " + stack);

    }
}
