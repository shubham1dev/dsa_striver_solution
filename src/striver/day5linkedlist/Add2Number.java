package striver.day5linkedlist;

public class Add2Number {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;

        int carry = 0;
        while(l1!=null && l2!=null) {

            int a = l1.val;
            int b = l2.val;

            int tot = (a+b+carry);
            carry = tot/10;
            tot = tot%10;


            if(head==null){
                head = new ListNode(tot);
                tail = head;
            }
            else {
                tail.next = new ListNode(tot);
                tail = tail.next;
            }
            l2 = l2.next;
            l1 = l1.next;

        }

        while(l1!=null){

            int tot  = l1.val+carry;
            carry = tot/10;
            tot =tot%10;
            if(head==null){
                head = new ListNode(tot);
                tail = head;
            }
            else {
                tail.next = new ListNode(tot);
                tail = tail.next;
            }
            l1 = l1.next;

        }

        while(l2!=null){

            int tot  = l2.val+carry;
            carry = tot/10;
            tot =tot%10;
            if(head==null){
                head = new ListNode(tot);
                tail = head;
            }
            else {
                tail.next = new ListNode(tot);
                tail = tail.next;
            }
            l2 = l2.next;

        }

        if(carry!=0){
            tail.next = new ListNode(carry);
        }
        return head;

    }

    public static void main(String []args) {

    }

}
