class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)

        visited = set()
        cnt = 0

        def helper(curr):
            if curr in visited:
                return False
            
            visited.add(curr)

            for j,neigh in enumerate(isConnected[curr]):
                if neigh == 1 and j not in visited:
                    helper(j)
            
            return True

        for i in range(n):
            if i not in visited and helper(i):
                cnt +=1
        
        return cnt
