import java.util.Scanner;

class Student{

    public Student(){}

    public Student(String name, String stream){
        this.name = name;
        this.stream = stream;
    }

    String name;
    String stream;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }
}


public class CallByValue {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name: ");
        String name = sc.nextLine();
        System.out.print("Enter you stream: ");
        String stream = sc.nextLine();
        Student stud = new Student(name, stream);
        sayHello(stud);
        System.out.println(stud);
    }

    static void sayHello(Student stud){
        stud.name = "Mr. " + stud.name;
    }


}
