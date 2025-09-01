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
    int findPosition(vector<int>& inorder, int value) {
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }

    TreeNode* buildSubtree(vector<int>& preorder, vector<int>& inorder, int& preorderIndex, int inorderStart, int inorderEnd) {
        if (preorderIndex >= preorder.size() || inorderStart > inorderEnd) {
            return NULL;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode* root = new TreeNode(rootValue);

        int rootPosition = findPosition(inorder, rootValue);
        root->left = buildSubtree(preorder, inorder, preorderIndex, inorderStart, rootPosition - 1);
        root->right = buildSubtree(preorder, inorder, preorderIndex, rootPosition + 1, inorderEnd);

        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int preorderIndex = 0;
        return buildSubtree(preorder, inorder, preorderIndex, 0, inorder.size() - 1);
    }
};