package striver.day17binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfBinaryTree {


      private static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    private class Pair {

        TreeNode node;
        int hd;

        public Pair(TreeNode n, int h){
            node = n;
            hd =h;
        }

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {


        if(root==null)
            return new ArrayList<>();

        TreeMap<Integer, ArrayList<Integer>> order =new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> temp =  new ArrayList<>();
        temp.add(root.val);
        q.add(new Pair(root,0));
        order.put(0, temp);

        while(!q.isEmpty()){
            int size = q.size();
            TreeMap<Integer, ArrayList> tt = new TreeMap<>();
            while(size-->0){

                Pair p = q.poll();
                TreeNode n = p.node;
                int h = p.hd;

                if(n.left!=null){
                    q.add(new Pair(n.left, h-1));
                    if(!tt.containsKey(h-1)){
                        temp = new ArrayList<>();
                        temp.add(n.left.val);
                        tt.put(h-1, temp);
                    }
                    else{
                        ArrayList<Integer> ls = tt.get(h-1);
                        ls.add(n.left.val);
                        tt.put(h-1, ls);
                    }

                }
                if(n.right!=null){
                    q.add(new Pair(n.right, h+1));
                    if(!tt.containsKey(h+1)){
                        temp = new ArrayList<>();
                        temp.add(n.right.val);
                        tt.put(h+1, temp);
                    }

                    else{
                        ArrayList<Integer> ls = tt.get(h+1);
                        ls.add(n.right.val);
                        tt.put(h+1, ls);
                    }
                }

            }

            for(int i: tt.keySet()){

                if(order.containsKey(i)){

                    ArrayList<Integer> cs = order.get(i);
                    Collections.sort(tt.get(i));
                    cs.addAll(tt.get(i));
                    order.put(i, cs);

                }
                else {
                    Collections.sort(tt.get(i));
                    order.put(i, tt.get(i));
                }

            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i: order.keySet()){
            ans.add(order.get(i));
        }
        return ans;

    }

    public static void main(String []args){
          TreeNode n = new TreeNode(3);
          TreeNode a = new TreeNode(9);
          TreeNode b = new TreeNode(20);
          TreeNode c = new TreeNode(15);
          TreeNode d = new TreeNode(7);


          n.left = a;
          n.right = b;
          b.left = c;
          b.right = d;
          List<List<Integer>> ans = new VerticalOrderTraversalOfBinaryTree().verticalTraversal(n);
          System.out.println(ans.toString());
    }


}
