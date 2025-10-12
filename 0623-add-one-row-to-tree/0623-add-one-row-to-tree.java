public class Solution {
    // Helper function to add nodes at a specified depth
    public TreeNode add(TreeNode root, int val, int depth, int curr) {
        // Base case: if root is null, return null
        if (root == null)
            return null;

        // Check if the current depth is equal to the target depth minus one
        if (curr == depth - 1) {
            // Store the original left and right subtrees
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;

            // Create new nodes with the given value
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            
            // Assign original left subtree to the left child of new left node
            root.left.left = lTemp;
            
            // Assign original right subtree to the right child of new right node
            root.right.right = rTemp;

            return root;
        }

        // Recursively call for left and right subtrees, incrementing depth
        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);

        return root;
    }

    // Main function to add one row to the tree
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // If depth is 1, create a new root node with given value
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        // Otherwise, call the add function starting from depth 1
        return add(root, val, depth, 1);
    }
}