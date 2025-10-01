/**
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently
 * occurring element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -10^5 <= Node.val <= 10^5
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to
 * recursion does not count).
 *
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
public class Solution {
    private final List<Integer> values = new ArrayList<>();
    private int maxVisits;
    private int visits;
    private TreeNode prev;

    public int[] findMode(TreeNode root) {
        // recursively visit all the nodes in the tree, in order
        walk(root);

        // gather the values to return
        int[] ret = new int[values.size()];
        int i = 0;
        for (int v : values) ret[i++] = v;
        return ret;

        //return values.stream().mapToInt(Integer::intValue).toArray();  // so much slower!
    }

    private void walk(final TreeNode node) {
        if (node == null) return;

        walk(node.left);

        // Inorder visit
        visit(node);
        prev = node;

        walk(node.right);
    }

    private void visit(TreeNode node) {
        if(prev != null && prev.val == node.val) {
            visits++; // visits to the current number
        } else {
            visits = 1; // new number encountered
        }

        if (visits > maxVisits) {
            maxVisits = visits; // visits to the same number has hit a new high
            values.clear(); // start a new list of numbers hitting this new high
            values.add(node.val);
        } else if (visits == maxVisits) {
            values.add(node.val); // visits to this number has reached the current high
        }
    }
}