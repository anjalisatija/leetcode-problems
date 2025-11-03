class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }
        
        int[] dp = new int[maxVal + 1];
        dp[1] = points[1];
        
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }
        
        return dp[maxVal];
    }
}