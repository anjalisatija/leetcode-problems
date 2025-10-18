class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, 0), dpCount(n, 1);
        dp[0] = 1;
        for (int i = 0; i<n; i++) {
            int longest = 0, longCount = 1;
            for (int j = 0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > longest) {
                        longest = dp[j];
                        longCount = dpCount[j];
                    }
                    else if (dp[j] == longest) {
                        longCount = longCount + dpCount[j];
                    }
                }
            }
            dp[i] = 1 + longest;
            dpCount[i] = longCount;
        }
        int lenLis = 0, count = 0;
        for (int i = 0; i<n; i++) {
            if (dp[i] > lenLis) {
                lenLis = dp[i];
                count = dpCount[i];
            }
            else if (dp[i] == lenLis) {
                count = count + dpCount[i];
            }
        }
        return count;
    }
};