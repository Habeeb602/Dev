class Solution {


    public static void main(String args[]){
        int[] a = {467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,467,512,512,512,512,512,512,512,512,512,512,512,350,350,350,350,350,350,107,107,107,107,107,107};
    
        long ans = ANDequalOR(a.length, a);

        System.out.println(ans);
    }
    
    public static long ANDequalOR(int n, int[] a) {
        // code here
        long ans = n;
        int i, st=-1, k;
        boolean continuos = false;
        for(i=0;i<n-1;i++){
            if(a[i] == a[i+1]){
                if(!continuos){
                    st = i;
                }
                continuos = true;
            }
            else{
                System.out.println((i+1) - st);
                if(continuos){
                    k = (i+1) - st;
                    System.out.println(fact(k) + " / " + (2*fact(k-2)));
                    ans += fact(k)/(2*fact(k-2));
                    System.out.println(k + " " + fact(k)/(fact(2)*fact(k-2)));
                    System.out.println(fact(k) + " / (" + fact(2) + " * " +(fact(k-2))+ ")");
                    continuos = false;
                }
            }
        }
        
        if(continuos){
            k = (i+1) - st;
            ans += fact(k)/(fact(2)*fact(k-2));
        }
        
        
        return ans;
    }
    
    private static long fact(long n){
        long ans = 1;
        System.out.println(n);
        for(long i=1;i<=n;i++){
            ans*=i;
            System.out.print(ans + ", ");
        }
        
        return ans;
    }
}