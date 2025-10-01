class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int[][] matrix=new int[][]{{1,1},{1,0}};
        int[][] matrixPow = getPower(matrix,n-1);
        return matrixPow[0][0];
    }
    private int[][] getPower(int[][] matrix,int n){
        if(n==1){
            return matrix;
        }
        if((n&1)==1){
            return getMatrixMulti2X2(matrix,getPower(matrix,n-1));
        }else{
            int[][] halfPower=getPower(matrix,n/2);
            return getMatrixMulti2X2(halfPower,halfPower);
        }
    }
    private int[][] getMatrixMulti2X2(int[][] m1,int[][] m2){
        int[][] ans=new int[m1.length][m1[0].length];
        ans[0][0]=m1[0][0]*m2[0][0]+m1[1][0]*m2[0][1];
        ans[0][1]=m1[0][0]*m2[1][0]+m1[1][0]*m2[1][1];
        ans[1][0]=m1[0][1]*m2[0][0]+m1[1][1]*m2[0][1];
        ans[1][1]=m1[0][1]*m2[1][0]+m1[1][1]*m2[1][1];
        return ans;
    }
}