class Solution {
public:
    int minCut(string s) {
        int n = s.size();
        if (n == 0) return 0;

        // Initialize the palindrome table
        std::vector<std::vector<bool>> dp(n, std::vector<bool>(n, false));

        // Fill the palindrome table
        for (int length = 1; length <= n; ++length) {
            for (int i = 0; i <= n - length; ++i) {
                int j = i + length - 1;
                if (length == 1) {
                    dp[i][j] = true;
                } else if (length == 2) {
                    dp[i][j] = (s[i] == s[j]);
                } else {
                    dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1];
                }
            }
        }

        // Initialize the cuts table
        std::vector<int> cuts(n, INT_MAX);

        for (int j = 0; j < n; ++j) {
            if (dp[0][j]) {
                cuts[j] = 0;
            } else {
                for (int i = 0; i < j; ++i) {
                    if (dp[i + 1][j]) {
                        cuts[j] = std::min(cuts[j], cuts[i] + 1);
                    }
                }
            }
        }

        return cuts[n - 1];
    }
};