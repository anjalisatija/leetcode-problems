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
    void iot(TreeNode* root,vector<int> &ans){
        if (root==NULL){return ;}
        iot(root->left,ans);
        ans.push_back(root->val);
        iot(root->right,ans);
    }
    int findSecondMinimumValue(TreeNode* root) {
        vector<int>ans;
        iot(root,ans);
        sort(ans.begin(),ans.end());
        ans.erase(unique(ans.begin(),ans.end()),ans.end());
        if (ans.size()<2){return -1;}
        return ans[1];
    }
};