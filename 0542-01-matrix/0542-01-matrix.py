class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
        queue = deque()
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    queue.append((i, j, 0))
                else:
                    mat[i][j] = float('inf')
        
        while queue:
            x, y, dist = queue.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < rows and 0 <= ny < cols and mat[nx][ny] > dist + 1:
                    mat[nx][ny] = dist + 1
                    queue.append((nx, ny, dist + 1))
        
        return mat
                        
                    