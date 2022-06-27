package striver.day6linkedlist;

import striver.day5linkedlist.ListNode;

public class IntersectionOf2LL {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1!=null && p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        if(p1==null) {
            p1 =headB;
            while(p2!=null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            p2 = headA;
        }
        else {
            p2 = headA;
            while(p1!=null){
                p1 = p1.next;
                p2 = p2.next;
            }
            p1= headB;
        }

        while(p1!=null && p2!=null) {
            if(p1==p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;

    }

    public static void main(String []args){

        ListNode node1a = new ListNode(4);
        ListNode node2a = new ListNode(1);
        node1a.next = node2a;
        ListNode node3a = new ListNode(8);
        node2a.next = node3a;
        ListNode node4a = new ListNode(4);
        node3a.next = node4a;
        ListNode node5a = new ListNode(5);
        node4a.next = node5a;

        ListNode node1b = new ListNode(5);
        ListNode node2b = new ListNode(6);
        node1b.next = node2b;
        ListNode node3b = new ListNode(1);
        node2b.next = node3b;
        node3b.next = node3a;

        ListNode res = getIntersectionNode(node1a, node1b);
        System.out.println();
    }


}
