package striver.day17binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    private class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }


    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        while(!q.isEmpty()){

            int size = q.size();
            int fp = 0;
            while(size-->0){
                Node n = q.poll();
                if(fp==0){
                    ans.add(n.data);
                    fp=1;
                }
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }

        }
        return ans;

    }

    public static void main(String []args) {}



}
