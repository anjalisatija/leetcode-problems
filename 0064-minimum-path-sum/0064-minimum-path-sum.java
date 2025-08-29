class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid[0].length;
        int m=grid.length;
        int[][] min=new int[m][n];
        min[0][0]=grid[0][0];
        for(int i=1;i<n;i++){
            min[0][i]=min[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            min[i][0]=min[i-1][0]+grid[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                min[i][j]=grid[i][j]+Math.min(min[i][j-1],min[i-1][j]);
            }
        }
        return min[m-1][n-1];
    }
}