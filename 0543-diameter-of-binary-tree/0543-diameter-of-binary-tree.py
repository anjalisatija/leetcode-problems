class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0

        def longest_path(node):
            if not node:
                return 0
            
            # Recursively find the longest path in both left child and right child
            left_path = longest_path(node.left)
            right_path = longest_path(node.right)
            
            # Path through the root
            self.diameter = max(self.diameter, left_path + right_path)
            
            # Return the longest one between left_path and right_path;
            # remember to add 1 for the path connecting the node and its parent
            return max(left_path, right_path) + 1
        
        longest_path(root)
        return self.diameter