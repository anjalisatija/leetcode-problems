class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;  // Separate variable to handle the 0th column
        int rows = matrix.length;
        int cols = matrix[0].length;

        // First pass: Mark rows and columns that need to be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the first element of the row as 0
                    matrix[i][0] = 0;

                    // Mark the first element of the column as 0
                    //  If it's the 0th column, update col0 instead
                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        // Second pass: Set elements to 0 based on markers (excluding 0th row and 0th column)
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Third pass: Handle the 0th row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) { // Corrected loop condition here
                matrix[0][j] = 0;
            }
        }

        // Fourth pass: Handle the 0th column
        if (col0 == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}