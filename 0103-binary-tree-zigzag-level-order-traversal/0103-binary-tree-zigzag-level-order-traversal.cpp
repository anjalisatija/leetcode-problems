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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> zTraversal;  // To store the final zigzag level order traversal
        if (!root)  // If the tree is empty, return an empty result
            return zTraversal;
        
        queue<TreeNode*> q;  // Queue to perform level order traversal
        q.push(root);  // Start with the root node
        bool LtR = true;  // Flag to alternate the direction
        
        while (!q.empty()) {
            int size = q.size();  // Number of nodes at the current level
            vector<int> row(size);  // Vector to hold the values for the current level
            
            // Process all nodes at the current level
            for (int i = 0; i < size; ++i) {
                TreeNode* node = q.front();  // Get the node at the front of the queue
                q.pop();  // Remove it from the queue
                
                // Determine the index in the row based on the current direction
                int id = LtR ? i : size - 1 - i;
                row[id] = node->val;  // Add the node value to the row
                
                // Add left and right children to the queue (if they exist)
                if (node->left) 
                    q.push(node->left);
                if (node->right) 
                    q.push(node->right);
            }
            
            // Add the current level's row to the final traversal result
            zTraversal.push_back(row);
            
            // Toggle the direction for the next level
            LtR = !LtR;
        }
        
        return zTraversal;  // Return the zigzag traversal result
    }
};