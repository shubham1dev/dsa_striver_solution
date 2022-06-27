package striver.day6linkedlist;

import striver.day5linkedlist.ListNode;

public class CheckPalindromeLL {

    public static boolean checkPalindrome(ListNode head){


        ListNode middle = findMiddle(head);

        return true;
    }

    private static ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String []args){

    }

}
