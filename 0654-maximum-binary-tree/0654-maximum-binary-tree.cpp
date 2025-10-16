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
    TreeNode* construct(vector<int>&nums, int left, int right){

        if(left>right) return NULL;
        int maxind=left;

        for(int i=left+1;i<=right;i++){
            if(nums[i]>nums[maxind]) maxind=i;
        }
        TreeNode* root=new TreeNode(nums[maxind]);

        root->left=construct(nums,left,maxind-1);
        root->right=construct(nums,maxind+1,right);

        return root;
    }

    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        return construct(nums,0,nums.size()-1);
    }
};