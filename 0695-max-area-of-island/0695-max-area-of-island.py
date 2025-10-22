class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        vis = [[False] * n for _ in range(m)]  # Visited array to track visited cells
        mca = 0  # Variable to store the maximum area

        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == 1 and not vis[i][j]:
                    # Start of a new island, initialize DFS
                    st = []
                    st.append([i, j])
                    vis[i][j] = True
                    ca = 0  # Counter for the current island's area

                    # DFS to explore the island
                    while st:
                        ind = st.pop(0)
                        ca += 1
                        x, y = ind[0], ind[1]

                        # Check all 4 neighbors (up, down, left, right)
                        if x + 1 < m and not vis[x + 1][y] and grid[x + 1][y] == 1:
                            vis[x + 1][y] = True
                            st.append([x + 1, y])
                        
                        if x - 1 >= 0 and not vis[x - 1][y] and grid[x - 1][y] == 1:
                            vis[x - 1][y] = True
                            st.append([x - 1, y])
                        
                        if y + 1 < n and not vis[x][y + 1] and grid[x][y + 1] == 1:
                            vis[x][y + 1] = True
                            st.append([x, y + 1])
                        
                        if y - 1 >= 0 and not vis[x][y - 1] and grid[x][y - 1] == 1:
                            vis[x][y - 1] = True
                            st.append([x, y - 1])

                    # Update maximum area
                    if ca > mca:
                        mca = ca

        return mca  # Return the maximum area found