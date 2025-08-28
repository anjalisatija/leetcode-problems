class Solution {
    public int[][] sortMatrix(int[][] grid) {
     int n = grid.length;
        
        // Sort bottom-left triangle (including main diagonal) in non-increasing order
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, true);
        }
        
        // Sort top-right triangle in non-decreasing order
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, false);
        }
        
        return grid;
    }
    
    private static void sortDiagonal(int[][] grid, int row, int col, boolean descending) {
        List<Integer> diagonal = new ArrayList<>();
        int i = row, j = col;
        while (i < grid.length && j < grid.length) {
            diagonal.add(grid[i][j]);
            i++;
            j++;
        }
        
        if (descending) {
            diagonal.sort(Collections.reverseOrder());
        } else {
            Collections.sort(diagonal);
        }
        
        i = row;
        j = col;
        for (int val : diagonal) {
            grid[i][j] = val;
            i++;
            j++;
        }
    }
}