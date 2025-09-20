class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }

    private int helper(int l, int r, int[][] dp) {
        if (l >= r) return 0;  
        if (dp[l][r] != 0) return dp[l][r];

        int res = Integer.MAX_VALUE;
        for (int x = l; x <= r; x++) {
            int cost = x + Math.max(helper(l, x - 1, dp), helper(x + 1, r, dp));
            res = Math.min(res, cost);
        }
        dp[l][r] = res;
        return res;
    }
}