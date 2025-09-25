class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize dp with the last row of the triangle
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Bottom-up DP computation
        for (int i = n - 2; i >= 0; i--) {
            int[] cur = new int[n];
            for (int j = i; j >= 0; j--) {
                cur[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
            dp = cur;
        }
        
        return dp[0];
    }
}