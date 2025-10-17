// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };

class Solution {
private:
    int calculateHeight(TreeNode* root) {
        if (!root) return -1;
        return 1 + max(calculateHeight(root->left), calculateHeight(root->right));
    }

    void placeElements(TreeNode* root, vector<vector<string>>& ans, int row, int left, int right) {
        if (!root) return;
        
        int col = (left + right) / 2;
        ans[row][col] = to_string(root->val);
        
        placeElements(root->left, ans, row + 1, left, col - 1);
        placeElements(root->right, ans, row + 1, col + 1, right);
    }

public:
    vector<vector<string>> printTree(TreeNode* root) {
        int height = calculateHeight(root);
        int m = height + 1;
        int n = pow(2, height + 1) - 1;
        vector<vector<string>> ans(m, vector<string>(n, ""));
        placeElements(root, ans, 0, 0, n - 1);
        return ans;
    }
};