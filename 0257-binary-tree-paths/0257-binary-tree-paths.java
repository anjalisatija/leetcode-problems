/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        traverse(root,ans,"");
        return ans;
    }


    public void traverse(TreeNode root,List<String> ans,String current){
        if(root==null)return;

        if(root.left==null&&root.right==null){
            if(current.equals("")){
            ans.add(current+root.val);
            }
            else{
            ans.add(current+"->"+root.val);
            }
            return;
        }

        
        if(current.equals("")){
            traverse(root.left,ans,current+root.val);
        }
        else{
            traverse(root.left,ans,current+"->"+root.val);
        }

        
        if(current.equals("")){
            traverse(root.right,ans,current+root.val);
        }
        else{
            traverse(root.right,ans,current+"->"+root.val);
        }
        
         
    }
}