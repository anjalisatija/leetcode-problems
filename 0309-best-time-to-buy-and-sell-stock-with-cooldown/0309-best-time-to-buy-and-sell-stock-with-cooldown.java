class Solution {
    public int maxProfit(int[] prices) {
        // Initialize the dynamic programming array
        int n = prices.length;
        int[][] dp = new int[n][2]; // dp[i][0] represents profit when not holding stock, dp[i][1] represents profit when holding stock

        // Base case: no stock at day 0
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            // Update profit when not holding stock
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // Update profit when holding stock
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]); 
                                               // the profit from two days ago (i.e., dp[i - 2][0])
        }

        // The maximum profit is obtained when not holding stock
        return dp[n - 1][0];
    }
// Explanation:
// We maintain two states: holding stock (1) and not holding stock (0).
// At each day, we update the maximum profit for both states based on the previous day’s information.
// The cooldown constraint is handled by considering the profit from two days ago (i.e., dp[i - 2][0]).


}