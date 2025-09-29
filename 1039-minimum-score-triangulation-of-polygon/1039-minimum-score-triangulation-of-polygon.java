class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
    int[][] dp = new int[n][n];
    
    // dp[i][j] = minimum cost to triangulate polygon from vertex i to j
    // Base case: segments with less than 3 vertices have cost 0
    
    // Fill dp table for increasing lengths
    for (int len = 3; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;
            
            // Try all possible middle vertices k
            for (int k = i + 1; k < j; k++) {
                int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
    }
    
    return dp[0][n - 1];
    }
}