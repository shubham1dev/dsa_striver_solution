package striver.day5linkedlist;

public class RemoveNthNodeFromBack {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head;
        ListNode p2 = head;
        while(n>0 && p1!=null){
            p1 = p1.next;
            n--;
        }

        if(p1==null){
            head = head.next;
            return head;
        }

        while(p1.next!=null){

            p1 = p1.next;
            p2 = p2.next;

        }

        p2.next = p2.next.next;


        return head;

    }

    public static void main(String []args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

    }


}
