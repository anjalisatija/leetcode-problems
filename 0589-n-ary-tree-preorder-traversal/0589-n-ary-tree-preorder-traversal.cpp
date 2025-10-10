/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
private:
    void helper(Node* root, vector<int>& vec) {
        if (!root) return;

        vec.push_back(root->val);

        for (auto child : root->children) {
            helper(child, vec);
        }
    }
public:
    vector<int> preorder(Node* root) {
        if (!root) return {};
        vector<int> ans;
        helper(root, ans);
        return ans;
    }
};