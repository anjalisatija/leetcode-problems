class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
  int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] is the minimum initial health required to reach the room (i, j)
        int[][] dp = new int[m][n];

        // the minimum initial health required to reach the princess is the room (m - 1, n - 1)
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // fill in the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        // fill in the last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        // fill in the rest of the matrix
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealth = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealth - dungeon[i][j]);
            }
        }

        // the minimum initial health required to reach the first room is the minimum initial health required to reach the room (0, 0)
        return dp[0][0];
    }
}