package striver.day6linkedlist;

import striver.day5linkedlist.ListNode;

public class DetectCycle {

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            if(slow==fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;

    }

    public static void main(String []args) {

    }

}
