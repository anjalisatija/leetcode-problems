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
    int isBal(TreeNode* root, bool &ans){
        if(root==nullptr){
            return 0;
        }
        int leftAns = isBal(root->left,ans);
        int rightAns = isBal(root->right,ans);
        if(abs(leftAns-rightAns)>1){
            ans = false;
        }
        return 1+ max(leftAns,rightAns);
    }
public:
    bool isBalanced(TreeNode* root) {
        if(root==nullptr){
            return true;
        }
        bool ans = true;
        isBal(root,ans);
        return ans;
    }
};