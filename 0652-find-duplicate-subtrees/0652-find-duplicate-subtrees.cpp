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
    string serialize(TreeNode* root, unordered_map<string,int> &mpp,
    vector<TreeNode*> &res){
        if(!root) return "#";

        string serial=to_string(root->val)+","+serialize(root->left,mpp,
        res)+","+serialize(root->right,mpp,res);

        mpp[serial]++;
        if(mpp[serial]==2) res.push_back(root);
        return serial;
    }
    
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        unordered_map<string,int>mpp;
        vector<TreeNode*>res;
        serialize(root,mpp,res);
        return res;
    }
};