class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;
        sort(nums.begin(), nums.end());
        
        int maxlength = 1;
        int length = 1;
        
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                length++;
            } else {
                maxlength = max(maxlength, length);
                length = 1;
            }
        }
        
        maxlength = max(maxlength, length);
        return maxlength;
    }
};