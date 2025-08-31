class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) return false;
        if (s1.isEmpty()) return s2.equals(s3);
        if (s2.isEmpty()) return s1.equals(s3);

        boolean[][] dp = new boolean[s3.length()][s1.length() + 1];
        for (int i = 0; i < s3.length(); ++i) {
            for (int j = 0; j < s1.length() + 1; ++j) {
                dp[i][j] = isInterleaveHelper(s1, s2, s3, i, j, dp);
            }
        }
         return dp[s3.length() - 1][s1.length()];
    }

    private boolean isInterleaveHelper(String s1, String s2, String s3,
                                       int i, int j,
                                       boolean[][] dp) {
        int s1Index = j - 1;
        int s2Index = i - j;
        if (s1Index >= s1.length() || s2Index >= s2.length()) return false;

        if (s1Index < 0) {
            if (s2.charAt(s2Index) != s3.charAt(i)) {
                return false;
            }
            if (i == 0) {
                return j == 0;
            }
            return dp[i - 1][j];
        }
        if (s2Index < 0) {
            if (s1.charAt(s1Index) != s3.charAt(i)) {
                return false;
            }
            if (i == 0) {
                return j == 1;
            }
            return dp[i - 1][j - 1];
        }

        boolean result = false;
        if (s1.charAt(s1Index) == s3.charAt(i)) {
            // try s1
            result = dp[i - 1][j - 1];
        }
        if (s2.charAt(s2Index) == s3.charAt(i)) {
            // try s2
            result = result || dp[i - 1][j];
        }
        return result;
    }
}