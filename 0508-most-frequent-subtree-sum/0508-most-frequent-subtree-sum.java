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

    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = Integer.MIN_VALUE;

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + helper(root.left) + helper(root.right);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, map.getOrDefault(sum, 0));

        return sum;

    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null) {
            return new int[]{};
        }

        helper(root);

        List<Integer> list = new ArrayList<>();

        for(int num : map.keySet()) {
            if(map.get(num) == maxFreq) {
                list.add(num);
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        

        return ans;

    }
}