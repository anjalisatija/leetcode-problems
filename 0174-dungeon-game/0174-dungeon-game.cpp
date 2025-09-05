class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int m = dungeon.size(), n = dungeon[0].size();
        vector<int> dp(n, 0);

        for (int row = m - 1; row >= 0; row--) {
            vector<int> temp(n, 0);
            for (int col = n - 1; col >= 0; col--) {
                if (row == m - 1 && col == n - 1)
                    temp[col] = max(1, 1 - dungeon[row][col]);
                else if (row == m - 1)
                    temp[col] = max(1, temp[col + 1] - dungeon[row][col]);
                else if (col == n - 1)
                    temp[col] = max(1, dp[col] - dungeon[row][col]);
                else
                    temp[col] = max(1, min(dp[col], temp[col + 1]) - dungeon[row][col]);
            }
            dp = temp;
        }

        return dp[0];
    }
};