package striver.day7LLA;

import striver.day5linkedlist.ListNode;

public class RotateLL {

    public int length(ListNode head) {

        int len = 0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;

    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null){
            return null;
        }

        int len = length(head);
        k = k%len;

        if(k==0)
            return head;

        ListNode p1 = head;
        ListNode p2 = head;
        while(k>0){
            k--;
            if(p2.next==null){
                p2=head;
            }
            else
                p2 = p2.next;
        }

        while(p2.next!=null){

            p1=p1.next;
            p2=p2.next;

        }
        p2.next = head;
        ListNode res = p1.next;
        p1.next = null;
        return res;

    }

    public static void main(String []args) {

    }

}
