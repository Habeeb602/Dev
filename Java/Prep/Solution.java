import java.util.ArrayList;
import java.util.List;

class Solution{
    public static void main(String[] args) {

    }

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0, m = A.size(), n = B.size();

        System.out.println(m + " - " + n);
        while(i<m && j<n){
            if(A.get(i).intValue() ==  B.get(j).intValue()){
                res.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i).intValue() > B.get(j)){
                j++;
            }
            else if(A.get(i) < B.get(j)){
                i++;
            }

            System.out.println(i + " " + j);
        }

        return res;
    }
}