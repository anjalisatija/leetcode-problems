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
    vector<vector<int>>pathSum(TreeNode*root,int targetSum){
        vector<vector<int>>result;
        vector<int>answer;
        vector<vector<int>>solution;
        getpath(root,result,answer);
        int sum=0;
        for(int i=0;i<result.size();i++){
            for(int j=0;j<result[i].size();j++){
                sum=sum+result[i][j];
            }
            if(sum==targetSum)
            solution.push_back(result[i]);
            sum=0;
        }
        return solution;
    }
    void getpath(TreeNode*root,vector<vector<int>>&result,vector<int>&answer){
        if(root==NULL)
            return;
        answer.push_back(root->val);
        if(root->left==NULL&&root->right==NULL){
            result.push_back(answer);
        }
        else{
            getpath(root->left,result,answer);
            getpath(root->right,result,answer);
        }
        answer.pop_back();
    }
};