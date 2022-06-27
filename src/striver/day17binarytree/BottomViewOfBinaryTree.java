package striver.day17binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    private class Node
    {
        int data;
        int hd;
        Node left, right;

        public Node(int item)
        {
            data = item;
            this.hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }


    public void solve(Node root, TreeMap<Integer, List<Integer>> order, int pos) {

        if(root==null){
            return;
        }
        else {

            if(order.containsKey(pos)){
                List<Integer> nodes = order.get(pos);
                nodes.add(root.data);
                order.put(pos, nodes);
            }
            else {
                List<Integer> ls = new ArrayList<>();
                ls.add(root.data);
                order.put(pos, ls);
            }
            solve(root.left, order, pos-1);
            solve(root.right, order, pos+1);

        }

    }

    public ArrayList<Integer> bottomView(Node root)
    {
        if(root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        root.hd = 0;
        q.add(root);
        Map<Integer, Integer> order= new TreeMap<>();
        order.put(root.hd, root.data);
        while(!q.isEmpty()){

            int size = q.size();
            while(size-->0){

                Node n = q.poll();
                if(n.left!=null) {
                    q.add(n.left);
                    n.left.hd = n.hd-1;
                    if(!order.containsKey(n.hd-1))
                    order.put(n.hd-1, n.left.data);
                }

                if(n.right!=null) {
                    q.add(n.right);
                    n.right.hd = n.hd+1;
                    if(!order.containsKey(n.hd+1))
                        order.put(n.hd+1, n.right.data);
                }

            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: order.keySet()){

            ans.add(order.get(i));
        }
        return ans;

    }

    public static void main(String []args) {

        Node root = new BottomViewOfBinaryTree().new Node(1);
        Node n1 = new BottomViewOfBinaryTree().new Node(8);
        Node n2 = new BottomViewOfBinaryTree().new Node(22);
        Node n3 = new BottomViewOfBinaryTree().new Node(5);
        Node n4 = new BottomViewOfBinaryTree().new Node(3);
        Node n5 = new BottomViewOfBinaryTree().new Node(4);
        Node n6 = new BottomViewOfBinaryTree().new Node(25);
        Node n7 = new BottomViewOfBinaryTree().new Node(10);
        Node n8 = new BottomViewOfBinaryTree().new Node(14);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n5.right = n8;

        ArrayList<Integer> ans = new BottomViewOfBinaryTree().bottomView(root);
        System.out.println(ans.toString());


    }


}
