class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        
        // Add border cells to the priority queue and mark them as visited
        for (int i = 0; i < m; i++) {
            minHeap.offer(new int[]{heightMap[i][0], i, 0});
            minHeap.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            minHeap.offer(new int[]{heightMap[0][j], 0, j});
            minHeap.offer(new int[]{heightMap[m - 1][j], m - 1, j});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int waterTrapped = 0;
        
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int height = cell[0];
            int row = cell[1];
            int col = cell[2];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int newHeight = heightMap[newRow][newCol];
                    waterTrapped += Math.max(0, height - newHeight);
                    minHeap.offer(new int[]{Math.max(height, newHeight), newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return waterTrapped;    
    }
}