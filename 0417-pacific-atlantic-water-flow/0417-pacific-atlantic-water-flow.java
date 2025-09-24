class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights==null || heights.length==0 || heights[0].length==0){
            return new ArrayList<>();
        }
        int rows = heights.length;
        int cols = heights[0].length;

        // Create visited arrays to track cells reachable by Pacific and Atlantic Oceans
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        performBFSForOcean(heights, pacific, getPacificBorderCells(rows, cols));
        performBFSForOcean(heights, atlantic, getAtlanticBorderCells(rows, cols));

        // Find and return the intersection of cells reachable by both oceans
        return findIntersectingCells(pacific, atlantic, rows, cols);
    }

    private List<Pair> getPacificBorderCells(int row, int col){
        List<Pair> bordercells = new ArrayList<>();
        for(int i=0; i<row; i++){
            bordercells.add(new Pair(i, 0)); //left colums
        }
        for(int j=0; j<col; j++){
            bordercells.add(new Pair(0, j)); // top row
        }
        return bordercells;
    }

    private List<Pair> getAtlanticBorderCells(int row, int col){
        List<Pair> bordercells = new ArrayList<>();
        for(int i=0; i<row; i++){
            bordercells.add(new Pair(i, col-1));
        }
        for(int j=0; j<col; j++){
            bordercells.add(new Pair(row-1, j));
        }
        return bordercells;
    }

    private void performBFSForOcean(int[][] heights, boolean[][] visited, List<Pair> bordercells){
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Pair> qu = new LinkedList<>(bordercells);

        for(Pair cell: bordercells){
            visited[cell.x][cell.y] = true;
        }

        //perfoem BFS
        while(!qu.isEmpty()){
            Pair cell = qu.poll();
            int x = cell.x;
            int y = cell.y;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check bounds, height condition, and if the cell is already visited
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
                        && !visited[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    visited[nx][ny] = true;
                    qu.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private List<List<Integer>> findIntersectingCells(boolean[][] pacific, boolean[][] atlantic, int rows, int cols){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

}
class Pair{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}