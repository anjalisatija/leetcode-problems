class Solution {
public:
    void perm(string nums, int i, vector<string>& ans){
        if (i>=nums.size()){ans.push_back(nums);return;}
        if (isdigit(nums[i])){perm(nums,i+1,ans);return;}
        nums[i]=tolower(nums[i]);
        perm(nums,i+1,ans);
        nums[i]=toupper(nums[i]);
        perm(nums,i+1,ans);
    }
    vector<string> letterCasePermutation(string s) {
        vector<string>ans;
        perm(s,0,ans);
        return ans;
    }
};