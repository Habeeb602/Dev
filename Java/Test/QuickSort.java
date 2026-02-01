/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        int[] a = getArray(head);

        quick(0,a.length-1,a);

        int i=0;
        ListNode temp = head;
        while(temp!=null){
            temp.val=a[i++];
            temp = temp.next;
        }

        return head;
    }


    private void quick(int l, int h, int[] a){

        if(l<h){

            int pivot = partition(l, h, a);

            quick(l, pivot, a);
            quick(pivot+1, h, a);
        }
    }

    private int partition(int l, int h, int[] a){

        int i = l-1;
        int j = h+1;
        int pivot = a[l];

        while(true){

            do{
                i++;
            }while(a[i]<pivot);

            do{
                j--;
            }while(a[j]>pivot);


            if(i>=j) return j;
            
            swap(a, i, j);     
        }
    }
    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private int[] getArray(ListNode head){

        int n = 0, i;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        int[] a = new int[n];
        for(temp=head,i=0;temp!=null && i<n;i++,temp=temp.next){
            a[i] = temp.val;
        }
        return a;
    }

}