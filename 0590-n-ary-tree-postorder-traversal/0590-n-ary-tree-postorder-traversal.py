
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        self.helper(res, root)
        return res

    def helper(self, res: list[int], root: 'Node') -> NoReturn:
        if root is None:
            return
        
        for node in root.children:
            self.helper(res, node)

        res.append(root.val)