package striver.day5linkedlist;

public class DeleteRandomNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
    public static void main(String []args){



    }

}
