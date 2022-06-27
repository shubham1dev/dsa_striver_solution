package striver.day5linkedlist;

import java.util.Scanner;

public class MiddleOfLL {

    class Node {
        int data;
        Node next;

        public Node(){
            int data = -1;
            next = null;
        }

        public Node(int data){
            this.data = data;
            next = null;
        }

    }

    public static void addToLL(Node head, int data){

        Node node = head;
        if(node.data==-1){
            head.data = data;
            head.next = null;
            return;
        }
        while(node.next!=null){
            node = node.next;
        }

        Node newNode = new MiddleOfLL().new Node(data);
        node.next = newNode;

    }

    public static void printLL(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
    }

    public static void main(String []args){


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = new MiddleOfLL().new Node();
        while(n-->0){
            addToLL(head, sc.nextInt());
        }

        Node middle = findMiddleNode(head);
        printLL(middle);

    }

    private static Node findMiddleNode(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
   }

}
