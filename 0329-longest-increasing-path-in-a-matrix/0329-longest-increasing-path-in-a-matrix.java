class Solution {
    private int[][] dist;
    public int getDist(int[][]matrix, int i, int j, int prev){
        if (i<0 || i>=matrix.length || j<0|| j>=matrix[0].length || matrix[i][j]<=prev) return 0;
        if (dist[i][j]!=-1) return dist[i][j];
        int max=Integer.MIN_VALUE;
        max=Math.max(max,getDist(matrix, i+1,j,matrix[i][j]));
        max=Math.max(max,getDist(matrix, i-1,j,matrix[i][j]));
        max=Math.max(max,getDist(matrix, i,j+1,matrix[i][j]));
        max=Math.max(max,getDist(matrix, i,j-1,matrix[i][j]));
       dist[i][j]=max+1;
       return max+1;
    }
    public int longestIncreasingPath(int[][] matrix) {
         dist= new int[matrix.length][matrix[0].length];
         int max=Integer.MIN_VALUE;
        for (int i=0; i<matrix.length; i++) Arrays.fill(dist[i],-1);
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (dist[i][j]!=-1) continue;
                max=Math.max(max,getDist(matrix,i,j,Integer.MIN_VALUE));
            }
        }
        return max;
    }
}