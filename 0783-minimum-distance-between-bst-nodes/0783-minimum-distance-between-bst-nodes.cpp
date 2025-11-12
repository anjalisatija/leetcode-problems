/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int minDiffInBST(TreeNode* root) {
        int min_diff = INT_MAX;
        TreeNode* prev = nullptr;
        inorder(root, prev, min_diff);
        return min_diff;
    }
private:
    void inorder(TreeNode* root, TreeNode*& prev, int& min_diff) {
        if (root) {
            inorder(root->left, prev, min_diff);
            if (prev) {
                min_diff = min(min_diff, root->val - prev->val);
            }
            prev = root;
            inorder(root->right, prev, min_diff);
        }
    }
};