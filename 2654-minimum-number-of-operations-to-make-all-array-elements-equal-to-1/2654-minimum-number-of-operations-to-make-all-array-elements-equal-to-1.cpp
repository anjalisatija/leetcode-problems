#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums) {
        int n = nums.size();
        int g = nums[0]; 
        int count = 0;
        int best = n + 1;

        // Step 1: Compute overall gcd and count 1s
        for (int i = 0; i < n; ++i) {
            g = gcd(g, nums[i]);
            if (nums[i] == 1) count++;
        }

        // Step 2: If overall gcd > 1, impossible
        if (g > 1) {
            return -1;
        }

        // Step 3: If we already have 1s
        if (count > 0) {
            return n - count;
        }

        // Step 4: Find smallest subarray with gcd == 1
        for (int i = 0; i < n; ++i) {
            int curr = nums[i];
            for (int j = i + 1; j < n; ++j) {
                curr = gcd(curr, nums[j]);
                if (curr == 1) {
                    best = min(best, j - i + 1);
                    break;
                }
            }
        }

        // Step 5: Return total operations
        return (best - 1) + (n - 1);
    }
};