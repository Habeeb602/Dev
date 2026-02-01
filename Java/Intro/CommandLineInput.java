public class CommandLineInput {
    public static void main(String[] args){
        System.out.print("You have given ");
        if(args.length > 0){
            for(int i=0;i<args.length;i++){
                System.out.print(args[i] + " ");
            }
        }
        else{
            System.out.print("nothing!");
        }
    }
}
