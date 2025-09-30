class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
    set<vector<int>> res;
    vector<int> curr;
    function<void(int)> backtrack;
    backtrack = [&](int first) {
        if (curr.size() >= 2) res.insert(curr);
        for (int i = first; i < nums.size(); i++) {
            if (curr.empty() || nums[i] >= curr.back()) {
                curr.push_back(nums[i]);
                backtrack(i + 1);
                curr.pop_back();
            }
        }
    };
    backtrack(0);
    return vector<vector<int>>(res.begin(), res.end());
    }
};