package striver.day17binarytree;

import codeforces.CR780.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

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

    private static class Pair {

        Node node;
        int hd;

        public Pair(Node n, int h){
            node = n;
            hd =h;
        }

    }

    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        if(root==null)
            return new ArrayList<>();

        TreeMap<Integer, Integer> order =new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));
        order.put(0, root.data);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){

                Pair p = q.poll();
                Node n = p.node;
                int h = p.hd;

                if(n.left!=null){
                    q.add(new Pair(n.left, h-1));
                    if(!order.containsKey(h-1)){
                        order.put(h-1, n.left.data);
                    }

                }
                if(n.right!=null){
                    q.add(new Pair(n.right, h+1));
                    if(!order.containsKey(h+1)){
                        order.put(h+1, n.right.data);
                    }
                }

            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: order.keySet()){
            ans.add(order.get(i));
        }
        return ans;


    }
}
