package striver.day7LLA;


import java.util.HashMap;
import java.util.Map;

public class CopyList {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {


        int i = 0;
        Node temp = head;
        Map<Node, Integer> pos = new HashMap<>();
        while(temp!=null){
           pos.put(temp,i);
           i++;
           temp = temp.next;
        }

        temp = head;
        Node []arr= new Node[pos.size()];
        Node res = null;
        Node tail = null;
        i = 0;
        while(temp!=null) {

            if(res==null){
                res = new Node(temp.val);
                tail =res;
            }
            else {
                tail.next = new Node(temp.val);
                tail = tail.next;
            }
            temp = temp.next;
            arr[i] = tail;
            i++;
        }

        temp = head;
        Node copy = res;
        while(temp!=null){

            if(temp.random!=null){
                copy.random = arr[pos.get(temp.random)];
            }

            temp = temp.next;
            copy = copy.next;
        }

        return res;


    }

    public static void main(String []args) {



    }

}
