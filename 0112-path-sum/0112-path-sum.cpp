// This class defines a solution for a problem where given a binary tree and a sum,
// the task is to determine if there is a root-to-leaf path such that adding up all the values
// along the path equals the given sum.
class Solution {
public:
// This function takes in a pointer to the root of a binary tree (TreeNode*) and an integer sum.
bool hasPathSum(TreeNode* root, int sum) {
    // If the current node is null, return false since there is no path starting from a null node.
    if(!root) return false;
    
    // If the current node's value is equal to the sum and it is a leaf node, return true
    // since we have found a path from root to leaf that sums up to the given sum.
    if(root->val==sum && root->left==NULL && root->right==NULL) return true;
    
    // Recursively check if there is a path starting from the left or right child that sums up to 
    // the given sum after subtracting the current node's value from it. Return true if either of the 
    // recursive call returns true.
    return hasPathSum(root->left,sum-root->val) || hasPathSum(root->right,sum-root->val);
}

};