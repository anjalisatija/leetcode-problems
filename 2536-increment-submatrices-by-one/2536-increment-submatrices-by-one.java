class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {   
        
        int[][] answer = new int[n][n];
        
        for (int[] A : queries) {
		
            int row1 = A[0], row2 = A[2];
			int col1 = A[1], col2 = A[3];
            
            for (int row = row1; row <= row2; row++) {
                for (int col = col1; col <= col2; col++) {
                    answer[row][col] += 1;
                }
            }
        }
        return answer;
    }
}