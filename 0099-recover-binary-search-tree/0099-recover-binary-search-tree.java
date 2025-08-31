/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode a =null, b= null;
    TreeNode prev = null;

    public void dfs(TreeNode root){

        if( root == null) return;

        dfs(root.left);
        if( prev != null && root.val < prev.val){
            if(a == null ){
                a = prev;
            } 
            b = root;
        }
        prev = root;

        dfs(root.right);
    }

    public void recoverTree(TreeNode root) {
        dfs(root);

        // swap values of the swapped nodes:
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}