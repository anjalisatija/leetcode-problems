import java.util.*;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;  // Initialize result to the smallest possible value

        // Iterate over all pairs of rows
        for (int top = 0; top < m; top++) {
            int[] colSum = new int[n];
            
            for (int bottom = top; bottom < m; bottom++) {
                // Update the column sums for the current row range
                for (int i = 0; i < n; i++) {
                    colSum[i] += matrix[bottom][i];
                }
                
                // Now, find the maximum sum of a subarray of colSum that is <= k
                result = Math.max(result, maxSumNoLargerThanK(colSum, k));
            }
        }
        
        return result;
    }

    private int maxSumNoLargerThanK(int[] colSum, int k) {
        int n = colSum.length;
        int sum = 0;
        int result = Integer.MIN_VALUE; // Declare result here
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0); // Add the 0 to handle cases where the sum itself is <= k
        
        for (int i = 0; i < n; i++) {
            sum += colSum[i];
            // Find the smallest prefix sum that, when subtracted from the current sum, gives a result <= k
            Integer target = set.ceiling(sum - k);
            if (target != null) {
                result = Math.max(result, sum - target);
            }
            set.add(sum);
        }
        
        return result;
    }
}