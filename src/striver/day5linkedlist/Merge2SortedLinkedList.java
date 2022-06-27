package striver.day5linkedlist;

public class Merge2SortedLinkedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;

        ListNode head =null;
        if(list1.val< list2.val){
            head = list1;
        }
        else
            head =list2;

        ListNode prev = null;
        while(list1!=null && list2!=null){

            if(list1.val< list2.val){
                ListNode temp = list1.next;
                list1.next = list2;
                prev = list2;
                list1 = temp;
            }
            else {

                if(prev==null) {

                    ListNode temp = list2.next;
                    list2.next = list1;
                    prev = list2;
                    list2 = temp;
                }

                else {

                    ListNode temp = list2.next;
                    prev.next = list2;
                    prev = list2;
                    list2.next = list1;
                    list2 = temp;

                }
            }

        }

        return head;

    }

    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String []args){

        ListNode head1 = new ListNode();
        head1.val = 5;
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(7);

        ListNode head2 = new ListNode();
        head2.val = 1;
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(head1,head2);

        printList(res);

    }

}
