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
    TreeNode* trimBST(TreeNode* root, int low, int high) {
        if(root == NULL)
            return root;

        // Passing alive child address to parent 
        root->left = trimBST(root->left, low, high);
        root->right = trimBST(root->right, low, high);
        
        // Deletion Code
        if(root->val < low || root->val > high){
            if(root->left != NULL)
                root = root->left;
            else if(root->right != NULL)
                root = root->right;
            else
                root = NULL;
        }

        return root;

    }
};