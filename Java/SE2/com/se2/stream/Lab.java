package com.se2.stream;

import com.se2.stream.utils.AnotherBook;
import com.se2.stream.utils.Book;
import com.se2.stream.utils.Person;
import com.se2.stream.utils.Item;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lab {

    public static void main(String[] args) {
        Lab lab = new Lab();

//        lab.q1();
//        lab.q2();
//        lab.q3();
//        lab.q4();
//        lab.q5();
//        lab.q6();
//        lab.q7();
//        lab.q8();
//        lab.q9();
//        lab.q10();
//        lab.q11();
//        lab.q12();
//        lab.q13();
        lab.q14();
    }

    private void q1(){
        /**
         * 1. Stream a list of int primitives between the range of 0 (inclusive) and 5 (exclusive). Calculate and
         * output the average
         * */

        System.out.println("IntStream.range(0,5).average() = " + IntStream.range(0, 5).average());
    }

    private void q2(){
        /**
         * 2. Given the Item class (in the zip file), declare a List typed for Item with the following Item’s:
         * a. id=1 name=”Screw”
         * b. id=2 name=”Nail”
         * c. id=3 name=”Bolt”
         * Stream the list and sort it so that it outputs “BoltNailScrew” i.e. alphabetic name order. Use Stream’s
         * forEach method to output the names (use the method reference version for the required Consumer
         * lambda).*/

        List<Item> items = Arrays.asList(new Item(1, "Screw"), new Item(2, "Nail"), new Item(1, "Bolt"));

        items.sort(Comparator.comparing(Item::getName));

        items.forEach(item -> System.out.print(item.getName()));

    }

    private void q3(){
        /**
         * 3. Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”), Arrays.asList(“a”,
         * “c”)) method call. Filter the stream so that only list’s that contain “c” make it through the filter.
         * Flatten the Stream<List<String>> to a Stream<String> using the flatMap() operation. Note that
         * flapMap() states in the API “Each mapped stream is closed after its contents have been placed into
         * this [new] stream.”. Use forEach() to output the new stream. */


        Stream<List<String>> listStream = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));

        listStream
                .flatMap(list -> list.stream())
                .filter(str -> str.equals("c"))
                .forEach(System.out::println);
    }

    private void q4(){
        /**
         * There are several parts to this: (QID 2.1738)
         * a. Using 1, 2 and 3 create a List of Integers.
         *  i. Stream the list and calculate the sum, using the sum() method from IntStream.
         *  ii. Stream the list again and calculate the maximum value, using the max() method from
         * IntStream.
         * b. Given the Person class (in the zip file), declare a List typed for Person with the following
         * Person’s:
         *  i. “Alan”, “Burke”, 22
         *  ii. “Zoe”, “Peters”, 20
         *  iii. “Peter”, “Castle”, 29
         * Using the max(Comparator) from Stream, calculate the oldest person in the list.
         * c. Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using the following
         * versions of reduce(), calculate the maximum value:
         *  i. Optional<T> reduce(BinaryOperator<T> accumulator)
         *  ii. T reduce(T identity, BinaryOperator<T> accumulator)*/


        // a)
        List<Integer> integerList = Arrays.asList(1, 2, 3);

        int intSum = integerList.stream()
                .mapToInt(integer -> integer)
                .sum();

        OptionalInt max = integerList.stream()
                .mapToInt(integer -> integer)
                .max();

        System.out.println("sum = " + intSum);
        System.out.println("max = " + max);


        // b)
        List<Person> personList = Arrays.asList(
                        new Person("Alan", "Burke", 22),
                        new Person("Zoe", "Peters", 20),
                        new Person("Peter", "Castle", 29)
        );


        Optional<Person> maxAge = personList.stream()
                .max(Comparator.comparing(person -> person.getAge()));
        System.out.println("maxAge = " + maxAge.orElseThrow());



        // c)
        List<Integer> nums = Arrays.asList(10, 47, 33, 23);

        Optional<Integer> sum = nums.stream().reduce((tSum, num) -> tSum + num);
        System.out.println("sum without having initial identity (Initial accumulator value) = " + sum.orElseThrow());

        int anotherSum = nums.stream().reduce(0, (tSum, num) -> tSum + num);
        System.out.println("anotherSum = " + anotherSum);
    }

    public void q5(){

        /**
         * Code a method public static Optional<String> getGrade(int marks) (QID 2.1826)
         * a. in the method getGrade:
         *  i. declare an empty optional, typed for String called grade
         *  ii. insert the following code:
         *      if (marks > 50) {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);}
         * b. in main():
         *  i. declare an Optional, typed for String named grade1 which is initialised to the return
         *      value of calling getGrade(50)
         *  ii. declare an Optional, typed for String named grade2 which is initialised to the return
         *      value of calling getGrade(55)
         *  iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN”
         *  iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of
         *      grade2; if false, use orElse() to output the contents of grade2 or “Empty”
         *  v. Notes:
         *  1. Optional’s are immutable.
         *  2. Optional.of(null); // NullPointerException
         *  3. Optional.ofNullable(null); // Optional.empty returned*/

        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);

        System.out.println("grade1.orElse(\"UNKNOWN\") = " + grade1.orElse("UNKNOWN"));

        if(grade2.isPresent()){
            grade2.ifPresent(str -> System.out.println("grade2: " + str));
        }
        else{
            System.out.println("grade2.orElse(\"Empty\") = " + grade2.orElse("Empty"));
        }
    }

    public static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();

        if(marks > 50){
            grade = Optional.of("PASS");
        }
        else{
            grade.of("FAIL");
        }

        return grade;
    }

    private void q6(){
        /**
         * Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
         *  a. title=”Thinking in Java”, price=30.0
         *  b. title=”Java in 24 hrs”, price=20.0
         *  c. title=”Java Recipes”, price=10.0
         * Stream the books and calculate the average price of the books whose price is > 10.
         * Change the filter to books whose price is > 90. Ensure you do not get an exception*/

        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        double avg = books.stream()
                .filter(book -> book.getPrice() > 90.0)
                .collect(Collectors.averagingDouble(book -> book.getPrice()));
        System.out.println("avg = " + avg);

    }

    private void q7(){
        /**
         * Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
         *  a. title=”Atlas Shrugged”, price=10.0
         *  b. title=”Freedom at Midnight”, price=5.0
         *  c. title=”Gone with the wind”, price=5.0
         * Stream the books and instantiate a Map named ‘bookMap’ that maps the book title to its price. To do
         * this use the collect(Collectors.toMap(Function fnToGetKey, Function fnToGetValue)). Iterate
         * through ‘bookMap’ (using the Map forEach(BiConsumer) method). The BiConsumer only outputs
         * prices where the title begins with “A”. */
        List<Book> books = Arrays.asList(
                new Book("Gone with the wind", 5.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Atlas Shrugged", 10.0)
        );


        books
                .stream()
//                .filter(book -> book.getTitle().startsWith("A"))
                .collect(Collectors.toMap(book -> book.getTitle(), book -> book.getPrice()))
                .forEach((bookTitle, bookPrice) -> {
                    if(bookTitle.startsWith("A")){
                        System.out.println(bookTitle + " " + bookPrice);
                    }
                });
    }

    private void q8(){
        /**
         * Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
         *  a. title=”Gone with the wind”, price=5.0
         *  b. title=”Gone with the wind”, price=10.0
         *  c. title=”Atlas shrugged”, price=15.0
         * In a pipeline which has no return type: (QID 2.1847)
         *   stream the books
         *   using the collect() method, generate a Map that maps the book title to its price
         *   using forEach(), output the title and price of each entry in the map
         * What happened and why? Fix this by using the Collectors.toMap(Function, Function,
         * BinaryOperator) method.*/

        List<Book> books = Arrays.asList(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas Shrugged", 15.0)
        );

        books
                .stream()
                .collect(Collectors.toMap(book -> book.getTitle(), book -> book.getPrice(), (originalPrice, currentPrice) -> currentPrice))
                .forEach((title, price) -> System.out.println(title + " -> Rs." + price));
    }

    private void q9(){
        /**
         * Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
         *  a. name=”Bob”, age=31
         *  b. name=”Paul”, age=32
         *  c. name=”John”, age=33
         * Pipeline the following where the return type is double: (QID 2.1810)
         *   stream the people
         *   filter the stream for Person’s whose age is < 30
         *   map to int primitives
         *   calculate the average age.
         * This should generate a NoSuchElementException. Using orElse(), fix the pipeline (not the filter) so
         * that 0.0 is returned instead of an exception being generated*/

        List<Person> people = Arrays.asList(
                new Person("Bob", "Khan", 31),
                new Person("Paul", "Ahamed", 32),
                new Person("John", "Ali", 33)
        );

        OptionalDouble cumlativeAge = people
                .stream()
                .filter(person -> person.getAge() < 30)
                .mapToInt(Person::getAge)
                .average();

        System.out.println("cumlativeAge = " + cumlativeAge.orElse(0.0));
    }

    private void q10(){
        /**
         * A question about Optional. Let us look at this in parts:
         * a. Declare an Optional, typed for Double, named ‘price’ using the Optional.ofNullable(20.0).
         * Output the Optional value for ‘price’ 3 times: using ifPresent(Consumer), orElse(T) and
         * orElseGet(Supplier). (QID 2.1849)
         * b. declare a new Optional, typed for Double, named ‘price2’ (or comment out (a) and re-use
         * ‘price’). Use Optional.ofNullable again but this time, pass in null.
         * i. Output ‘price2’ in a normal System.out.println().
         * ii. check to see if price2 isEmpty() and if so output “empty”.
         * iii. do (ii) again except this time use the more functional “ifPresent(Consumer)” method.
         * iv. initialise a Double x to the return of “price2.orElse(44.0)”. Output and observe the
         * value of x.
         * c. declare a new Optional, typed for Double, named ‘price3’ (or comment out (b) and re-use
         * ‘price’). Use Optional.ofNullable passing in null.
         * i. initialise a Double z to the return of “price3.orElseThrow(() -> new
         * RuntimeException(“Bad Code”). Output and observe the value of z.*/


        Optional<Double> price = Optional.ofNullable(20.0);

        // a)
        price.ifPresent((p) -> System.out.println("price = " + p));
        System.out.println("price.orElse(0.0) = " + price.orElse(0.0));
        System.out.println("price.orElseGet(() -> 10.0) = " + price.orElseGet(() -> 10.0));


        // b)
        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println("price2 = " + price2);
        System.out.println("price2.isEmpty() = " + (price2.isEmpty() ? "empty" : price2.get()));
        price2.ifPresentOrElse(p -> System.out.println("price.ifPresentOrElse() = " + p), () -> System.out.println("Empty"));

        Double x = price2.orElse(44.00);
        System.out.println("x = " + x);


        // c)
        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
        System.out.println("z = " + z);
    }


    private void q11(){
        /**
         * Given the AnotherBook class (in the zip file), declare a List typed for AnotherBook namely ‘books’
         * with the following AnotherBook’s:
         *  a. title=”Gone with the wind”, genre=”Fiction” (QID 2.1858)
         *  b. title=”Bourne Ultimatum”, genre=”Thriller”
         *  c. title=”The Client”, genre=”Thriller”
         * Declare the following: List<String> genreList = new ArrayList<>();
         * Stream books so that genreList refers to a List containing the genres of the books in the books List.*/

        List<AnotherBook> books = Arrays.asList(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );

        List<String> genreList = books
                .stream()
                .map(AnotherBook::getGenre).toList();

        System.out.println("genreList = " + genreList);

        Set<String> genreSet = books
                .stream()
                .map(AnotherBook::getGenre)
                .collect(Collectors.toSet());

        System.out.println("genreSet = " + genreSet);

    }

    private void q12(){
        /**
         * There are two parts:
         * a. Generate a DoubleStream using the of() method consisting of the numbers 0, 2 and 4. Note
         * that this stream is a stream of primitives and not a stream of types. Filter in odd numbers only
         * and sum the remaining stream. You should get 0. (QID 2.2024)
         * b. Using 1.0 and 3.0, generate a stream of Double’s. Map them to primitive double’s. Filter in
         * even numbers only and calculate the average. Output the result without running the risk of
         * generating an exception.
         * */

        double oddNumberSum = DoubleStream.of(0, 2, 4)
                .filter(doub -> doub % 2 != 0)
                .sum();
        System.out.println("oddNumberSum = " + oddNumberSum);

        OptionalDouble evenNumAvg = DoubleStream.of(1.0, 3.0)
                .filter(doub -> doub % 2 == 0)
                .average();

        evenNumAvg.ifPresentOrElse(avg -> System.out.println("evenNumAvg = " + avg), () -> System.out.println("empty"));

    }

    private void q13(){
        /**
         * This question demonstrates lazy evaluation. Declare the following List<Integer> ls =
         * Arrays.asList(11, 11, 22, 33, 33, 55, 66);
         * a. stream the List (note that this is possible because List is a Collection and Collection defines a
         * stream() method); ensure only distinct (unique) numbers are streamed; check if “any match”
         * 11. You should get true for this.
         * b. stream the List again (this is necessary because once a stream is closed by a previous terminal
         * operation, you must re-create the stream); check to see if “none match” the expression
         * x%11>0. Note that the terminal operation noneMatch(Predicate) needs to return false for
         * every element in the stream for noneMatch() to return true. In other words, “none of them
         * match this….that’s correct, none of them do; return true”. You should get true here as well.*/

        // a)

        List<Integer> list = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        boolean isElevenExists = list
                .stream()
                .distinct()
                .anyMatch(integer -> integer == 11);

        System.out.println("isElevenExists = " + isElevenExists);

        boolean listIntegerMod11 = list.
                stream()
                .noneMatch(num -> num%11 > 0);

        System.out.println("listIntegerMod11 = " + listIntegerMod11);

        list
                .stream()
                .distinct()
                .forEach((num) -> System.out.println(num + " % 11 = " + num%11));
    }

    private void q14(){
        // a)
        AtomicInteger ai = new AtomicInteger();
        int cnt = 0;
        List<Integer> evenNums = Stream.of(10, 11, 23, 24)
                .parallel()
                .filter(num -> {
                    ai.incrementAndGet();
                    System.out.println(ai);
                    return num % 2 == 0;
                })
                .toList();

        System.out.println("evenNums = " + evenNums);
        System.out.println("ai = " + ai);


        // b)
        AtomicInteger ai2 = new AtomicInteger();
        Stream<Integer> stream =  Stream.of(11, 11, 22, 33);

        stream.filter(num -> {
            ai2.incrementAndGet();
            return num % 11 == 0;
        }).forEach(System.out::println);

        System.out.println("ai2 = " + ai2);
    }
}
