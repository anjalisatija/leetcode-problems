class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        
        // If k is large, solve using the unlimited transactions approach
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        // DP table: dp[t][i] - max profit up to day i with at most t transactions
        int[][] dp = new int[k + 1][n];
        
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0]; // Tracks max(dp[t-1][j] - prices[j])
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }
        
        return dp[k][n - 1];
    }
}