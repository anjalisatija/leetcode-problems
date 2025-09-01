class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if (inorder.empty() || postorder.empty()) {
            return nullptr;
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.size()-1, 0, postorder.size()-1);
    }
    
    TreeNode* buildTreeHelper(vector<int>& inorder, vector<int>& postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return nullptr;
        }
        int rootVal = postorder[postEnd];
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int leftSubtreeSize = rootIndex - inStart;
        TreeNode* root = new TreeNode(rootVal);
        root->left = buildTreeHelper(inorder, postorder, inStart, rootIndex-1, postStart, postStart+leftSubtreeSize-1);
        root->right = buildTreeHelper(inorder, postorder, rootIndex+1, inEnd, postStart+leftSubtreeSize, postEnd-1);
        return root;
    }
};