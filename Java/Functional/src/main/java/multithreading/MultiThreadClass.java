package multithreading;

public class MultiThreadClass implements Runnable{

    private int num;
    public MultiThreadClass(int num){
        this.num = num;
    }


    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Thread Number " + num + ": counting " + i);

//            if(num == 2){
//                throw new RuntimeException();
//            }

            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
        }
    }

}
