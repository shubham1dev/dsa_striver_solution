package striver.day6linkedlist;

import striver.day5linkedlist.ListNode;

public class ReverseByK {

    public static ListNode reverse(ListNode prev, ListNode curr, int k){

        return null;
    }


    public static  ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head;
        ListNode res= null;
        int count = 0;
        while(ptr!=null){

        }

        return null;

    }

    public static void main(String []args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseKGroup(head, 2);

    }

}
