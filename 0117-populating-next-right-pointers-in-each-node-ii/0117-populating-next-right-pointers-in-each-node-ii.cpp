/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    void lot(Node* root, unordered_map<int,vector<Node*>> &k, int laval){
        if (root==NULL){return;}
        k[laval].push_back(root);
        lot(root->left,k,laval+1);
        lot(root->right,k,laval+1);
    }
    Node* connect(Node* root) {
        unordered_map<int,vector<Node*>>k;
        lot(root,k,0);
        for (auto &it:k){
            vector<Node*>l=it.second;
            for (int i=0;i<l.size()-1;i++){
                if (l[i]!=NULL){l[i]->next=l[i+1];}
            }
            if (l.back()!=NULL){l.back()->next=NULL;}
        }
        return root;
    }
};