package striver.day6linkedlist;

import striver.day5linkedlist.ListNode;

public class StartingPointOfLoop {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean fp = false;

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow){
                fp = true;
                break;
            }

        }

        if(!fp)
            return null;

        slow = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String []args) {




    }

}
