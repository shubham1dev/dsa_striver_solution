package striver.day5linkedlist;

import java.util.Scanner;

public class ReverseLinkedList {


    public ListNode reverseList(ListNode node) {


        ListNode prev= null;
        ListNode curr = node;
        ListNode head = null;
        while(curr!=null){

            if(curr.next==null) {
                head = curr;
            }
            ListNode temp = curr.next;
            curr.next =prev;
            prev = curr;
            curr = temp;

        }

        return head;

    }

    public static void printlist(ListNode node) {

        while(node!=null) {

            System.out.print(node.val+"->");
            node = node.next;
        }

    }

    public static void main(String [] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printlist(head);
        ListNode res = new ReverseLinkedList().reverseList(head);
        printlist(res);



    }

}
