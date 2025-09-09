class Solution {
public:
    
    void Helper(int ind, int target, vector<int>& ds, int k,
                vector<vector<int>>& ans) {
        if (target == 0 && ds.size() == k) {
            ans.push_back(ds);
            return;
        }

        if (ind > 9 || target < 0) {
            return;
        }

        ds.push_back(ind);
        Helper(ind + 1, target - ind, ds, k, ans);
        ds.pop_back();

        Helper(ind + 1, target, ds, k, ans);
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<int> ds;
        vector<vector<int>> ans;

        Helper(1, n, ds, k, ans);

        return ans;
    }
};