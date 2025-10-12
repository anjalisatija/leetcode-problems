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

    // Helper function to recursively merge two trees
    public static TreeNode merge(TreeNode root1, TreeNode root2){
        // If both nodes are null, there's nothing to merge
        if (root1 == null && root2 == null) {
            return null;
        }

        // If one of the nodes is null, return the non-null node
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // Create a new node with the sum of values from root1 and root2
        TreeNode nn = new TreeNode(root1.val + root2.val);

        // Recursively merge the left children
        nn.left = merge(root1.left, root2.left);

        // Recursively merge the right children
        nn.right = merge(root1.right, root2.right);

        // Return the merged node
        return nn;
    }

    // Main method that merges two binary trees
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Start merging from the root of both trees
        return merge(root1, root2);
    }
}