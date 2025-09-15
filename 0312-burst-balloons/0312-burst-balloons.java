class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Add 1 at both ends for easier calculations
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // len is the length of the subarray
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int i = left + 1; i < right; i++) {
                    int coins = newNums[left] * newNums[i] * newNums[right];
                    coins += dp[left][i] + dp[i][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}