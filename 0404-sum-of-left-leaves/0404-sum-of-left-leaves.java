/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum[] = { 0 };
        helper(root, sum, false);
        return sum[0];
    }

    private void helper(TreeNode root, int[] sum, boolean isRight) {
        if (root == null) {
            return;
        }
        // Making sure that it is a leaf node
        // add sum only if it is not a part of right sub-tree
        if (root.left == null && root.right == null && isRight) {
            sum[0] = sum[0] + root.val;
        }
        helper(root.left, sum, true);
        helper(root.right, sum, false);
    }
}