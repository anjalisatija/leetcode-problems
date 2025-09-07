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
 import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ll=new ArrayList<>();
        rightside(root, ll,0 );
        return ll;
    }
    public static void rightside(TreeNode root,ArrayList<Integer> ll,int level)
    {
        if(root==null)return;
        if(level==ll.size())
        {
            ll.add(root.val);
        }
        rightside(root.right,ll,level+1);
        rightside(root.left,ll,level+1);
       
    }
}