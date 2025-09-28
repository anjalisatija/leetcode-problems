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

    TreeNode* findlastleft(TreeNode* root){
        if(root->left==NULL){
            return root;
        }

        return findlastleft(root->left);
    }

    TreeNode* helper(TreeNode* root){

        if(root->left==NULL){
            return root->right;
        }

        else if(root->right==NULL){
            return root->left;
        }

        else{
            TreeNode* leftchild=root->left;
            TreeNode* lastleft=findlastleft(root->right);
            lastleft->left=leftchild;
        }

        return root->right;
    }

    TreeNode* deleteNode(TreeNode* root, int key) {

        TreeNode* node=root;

        if(root==NULL){
            return root; 
        }

        if(root->val==key){
            return helper(root);
        }

        while(node!=NULL){

            if(node->val>key){
                if(node->left!=NULL && node->left->val==key){
                    node->left=helper(node->left);
                    break;
                }

                else{
                    node=node->left;
                }
            }

            else{
                
                if(node->right!=NULL && node->right->val==key){
                    node->right=helper(node->right);
                    break;
                }

                else{
                    node=node->right;
                }

            }
        }

        return root;
    }
};