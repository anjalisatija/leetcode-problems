class Solution {
public:
    static int cross(const vector<int>& o, const vector<int>& a, const vector<int>& b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - 
               (a[1] - o[1]) * (b[0] - o[0]);
    }

    vector<vector<int>> outerTrees(vector<vector<int>>& trees) {
        sort(trees.begin(), trees.end());

        vector<vector<int>> lower, upper;

        // Build lower hull
        for (const auto& p : trees) {
            while (lower.size() >= 2 && cross(lower[lower.size()-2], lower.back(), p) < 0) {
                lower.pop_back();
            }
            lower.push_back(p);
        }

        // Build upper hull
        for (int i = trees.size() - 1; i >= 0; --i) {
            const auto& p = trees[i];
            while (upper.size() >= 2 && cross(upper[upper.size()-2], upper.back(), p) < 0) {
                upper.pop_back();
            }
            upper.push_back(p);
        }

        // Combine and remove duplicates
        set<vector<int>> result(lower.begin(), lower.end());
        result.insert(upper.begin(), upper.end());

        return vector<vector<int>>(result.begin(), result.end());
    }
};
