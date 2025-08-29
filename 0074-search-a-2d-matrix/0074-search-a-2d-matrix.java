class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int midRow = (top + bottom) / 2;
            int rowStart = matrix[midRow][0];
            int rowEnd = matrix[midRow][matrix[midRow].length - 1];

            if (rowStart > target ) {
                bottom = midRow - 1;
            } else if (rowEnd < target) {
                top = midRow + 1;
            } else {
                int left = 0;
                int right = matrix[midRow].length - 1;
                while (left <= right) {
                    int midCol = (left + right) / 2;
                    if (matrix[midRow][midCol] < target) {
                        left = midCol + 1;
                    } else if (matrix[midRow][midCol] > target) {
                        right = midCol - 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}