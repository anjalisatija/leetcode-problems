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
    int sumNumbers(TreeNode* root) {
        int total = 0;
        string str = "";
        solver(root, total, str);
        return total;
    }

    void solver(TreeNode* root, int& total, string str) {
        //If node is nullptr
       if (root == nullptr) {
           return;
        }

        str += to_string(root->val);

        // If it's a leaf node
        if (root->left == nullptr && root->right == nullptr) {
            total += stoi(str);
            return;
        }

        // Recurse to left and right children
        solver(root->left, total, str);
        solver(root->right, total, str);
    }
};