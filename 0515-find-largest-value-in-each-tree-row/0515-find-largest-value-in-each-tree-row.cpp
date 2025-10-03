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
    
    vector<int> lvlorder(TreeNode* root, vector<int>& ans){
        if(!root) return {};
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int n = q.size();
            int maxi=INT_MIN; //Don't initialise maxi to 0, bc -
                             //root value can be negative. 
            for(int i=0;i<n;i++){
                TreeNode* curr = q.front();
                q.pop();
                if(curr->left != NULL) q.push(curr->left);
                if(curr->right != NULL) q.push(curr->right);
                maxi = max(maxi,curr->val);
            }
            ans.push_back(maxi);
        }
        return ans;
        
    }

    vector<int> largestValues(TreeNode* root) {
        vector<int> ans;
        return lvlorder(root, ans);
    }
};