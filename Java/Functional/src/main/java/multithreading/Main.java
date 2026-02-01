package multithreading;

public class Main {
    public static void main(String[] args) {



        for(int i=0;i<5;i++){
            MultiThreadClass mt1 = new MultiThreadClass(i+1);
            Thread t1 = new Thread(mt1);
            t1.start();
            System.out.println("isAlive: " + (i+1) +" " + t1.isAlive());
            System.out.println("isDaemon " + (i+1) +" " + t1.isDaemon());
            System.out.println("isInterrupted " + (i+1) +" " + t1.isInterrupted());


        }

//        MultiThreadClass mt2 = new MultiThreadClass(2);
//        Thread t2 = new Thread(mt2);
//        t2.start();
        System.out.println("I'm from main ;)");
    }
}
