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
    public int pathSum(TreeNode root, int targetSum) {
        AtomicInteger count = new AtomicInteger(0);
        util(root, targetSum, count);
        return count.get();
    }

    private void util(TreeNode root, int targetSum, AtomicInteger count) {
        if (root == null) {
            return;
        }

        findPath(root, targetSum, count, 0L);
        util(root.left, targetSum, count);
        util(root.right, targetSum, count);
    }

    private void findPath(TreeNode root, int targetSum, AtomicInteger count, long sum) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (sum == targetSum) {
            count.incrementAndGet();
        }

        findPath(root.left, targetSum, count, sum);
        findPath(root.right, targetSum, count, sum);
    }
}