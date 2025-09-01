class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size();

        vector<vector<int>> dp(m, vector<int>(m, -1));
        
        for(int j = 0; j < m; j++) {
            dp[m - 1][j] = triangle[m - 1][j];
        }
        
        for(int j = m - 2; j >= 0; j--) {
            for(int i = 0; i <= j; i++) {
                int sameColumnNextRow = triangle[j][i] + dp[j + 1][i];
                int nextColumnNextRow = triangle[j][i] + dp[j + 1][i + 1];

                dp[j][i] = min(sameColumnNextRow, nextColumnNextRow);
            }
        }
        
        return dp[0][0];
    }
};