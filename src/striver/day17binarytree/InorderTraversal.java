package striver.day17binarytree;

import java.util.ArrayList;
import java.util.List;



public class InorderTraversal {


    private class TreeNode {
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

    public void solve(TreeNode node, List<Integer> ans) {

        if(node==null)
            return;
        else {

            solve(node.left, ans);
            ans.add(node.val);
            solve(node.right, ans);

        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<Integer>();
        solve(root, ans);
        return ans;

    }





  }

}
