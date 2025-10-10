class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:

        # special case if no operations, return m * n
        if len(ops) == 0:
            return m * n
        
        # find the smallest x and y values
        smallestX = ops[0][0]
        smallestY = ops[0][1]

        for i in range(len(ops)):
            x = ops[i][0]
            y = ops[i][1]

            smallestX = min(smallestX, x)
            smallestY = min(smallestY, y)
        
        # return sum
        return smallestX * smallestY