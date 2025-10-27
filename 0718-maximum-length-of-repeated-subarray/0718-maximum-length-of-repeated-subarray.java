class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;

        int maxSubLen = 0;
        int [][]dp = new int[n+1][m+1];
        // by default if i == 0 or j == 0 , then commonSubArrayLen = 0 
        for (int i=1 ;i<=n ;i++){
            for (int j=1 ;j<=m ;j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+ 1; 
                    maxSubLen = Math.max(dp[i][j],maxSubLen);
                }
            }
        }

        return maxSubLen;
    }
}