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
    void traversal(TreeNode* root, vector<int> &res){
        if(!root) return;
        traversal(root->left, res);
        res.push_back(root->val);
        traversal(root->right, res);
    }

    bool findTarget(TreeNode* root, int k) {
        vector<int> res;
        traversal(root,res); // Get sorted values
        int left = 0, right = res.size() - 1;

        while(right > left){
            if(res[left] + res[right] == k) return true;
            if(res[left] + res[right] > k) right--;
            else left++;
        }
        
        return false;
    }
};