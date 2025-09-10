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
private int count = 0;  // To track the number of nodes visited
    private int result = -1;  // To store the k-th smallest value

    // Function to find the kth smallest element in the BST
    public int kthSmallest(TreeNode root, int k) {
        // Perform an in-order traversal to find the kth smallest element
        inOrderTraversal(root, k);
        return result;
    }

    // Helper function to perform in-order traversal
    private void inOrderTraversal(TreeNode node, int k) {
        // If the node is null, return (base case)
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left, k);

        // Increment the count of visited nodes
        count++;
        
        // If count equals k, we've found the k-th smallest element
        if (count == k) {
            result = node.val;
            return;  // No need to continue traversal
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }
}