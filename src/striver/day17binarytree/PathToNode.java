package striver.day17binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {
     static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
 }
    public ArrayList<Integer> solve(TreeNode node, int N, ArrayList<Integer> ans){

         if(node==null)
             return new ArrayList<>();
         else if(node.val==N) {
            ans.add(node.val);
             return ans;
         }
         else {

             ArrayList<Integer> temp = new ArrayList<>(ans);
             temp.add(node.val);
             ArrayList<Integer> fp = solve(node.left, N, temp);
             if(fp.size()>0){
                 return fp;
             }

             ArrayList<Integer> temp2 = new ArrayList<>(ans);
             temp2.add(node.val);
             fp = solve(node.right,N, temp2);
             if(fp.size()>0){
                 return fp;
             }
         }
         return new ArrayList<>();
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {

         ArrayList<Integer> ans = new ArrayList<>();
         ArrayList<Integer> cs = solve(A, B, ans);
         return cs;

     }

     public static void main(String []args) {

         TreeNode n1 = new TreeNode(1);
         TreeNode n2 = new TreeNode(2);
         TreeNode n3 = new TreeNode(3);
         TreeNode n4 = new TreeNode(4);
         TreeNode n5 = new TreeNode(5);
         TreeNode n6 = new TreeNode(6);
         TreeNode n7 = new TreeNode(7);

         n1.left = n2;
         n1.right = n3;
         n2.left = n4;
         n2.right = n5;
         n3.left = n6;
         n3.right = n7;
         List<Integer> ans = new PathToNode().solve(n1, 6);
         System.out.println(ans.toString());


     }

}
