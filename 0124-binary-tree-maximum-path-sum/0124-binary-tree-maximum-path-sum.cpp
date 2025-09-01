/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
    int res = INT_MIN;
    int helper(TreeNode* root) {
        if (!root)
            return 0;

        int lh = helper(root->left);
        int rh = helper(root->right);

        res = max(res, max(root->val, max(root->val+max(lh, rh), root->val+lh+rh)));
        
        return max(root->val, root->val + max(lh, rh));
    }

public:
    int maxPathSum(TreeNode* root) {
        helper(root);
        return res;
    }
};