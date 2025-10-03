# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        def get_depth(root,current_depth) ->(int,int):
            left_depth=-1
            right_depth=-1
            if root.left: 
                left_value,left_depth=get_depth(root.left,current_depth+1)
            if root.right: 
                right_value,right_depth=get_depth(root.right,current_depth+1)
            
            if  left_depth >right_depth:
                return left_value,left_depth
            if  left_depth < right_depth:
                return right_value,right_depth
            if  (left_depth>0)and (left_depth == right_depth):
                return left_value,left_depth
            return root.val ,current_depth
        val,depth=get_depth(root,0)
        return val