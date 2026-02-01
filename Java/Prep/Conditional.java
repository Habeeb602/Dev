import java.time.LocalDate;
import java.util.Scanner;

public class Conditional {

    public enum Days{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String args[]){

        /*
        System.out.print("Enter a character: ");
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println(ch + " is a Vowel");
                break;
            default:
                System.out.println(ch + " is a Consonant");
        }

        System.out.print("Enter name: ");
        String st = sc.next();
        switch(st){
            case "Habeeb":
                System.out.println("Hey Habeeb");
                break;
            case "Sumaiya":
                System.out.println("Hey Sumaiya");
                break;
            default:
                System.out.println("Hey Comrade!!!");
        }



//        int x = 0;
//        System.out.println(x++ + ++x + ++x + ++x);
////        0 + 2 + 3 + 4


        int i;
        outer_label:
        while(true){
            i=0;
            while(true){
                if(i>=20){
                    break outer_label;
                }
                else {
                    System.out.println(i++);
                }

            }
        }


         */

        //enums
        /*
        Days day = Days.WEDNESDAY;
        day = Days.valueOf("FRIDAY");
        switch(day){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
            case SATURDAY:
                System.out.println("It's " + day.name());
                break;

        }


         */

        print(LocalDate.of(2015, 8, 5).getDayOfWeek());

    }

    static void print(Object o){
        System.out.println(o.toString());
    }
}
