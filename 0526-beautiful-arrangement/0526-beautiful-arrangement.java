class Solution {
    public int countArrangement(int n) {
        return helper(1, n, 0);     // Start with the helper function from position 1...
    }

    public int helper(int m, int n, int mask) {
        // Base case: If all positions are filled, return 1 for a valid arrangement...
        if (m > n)
            return 1;
        
        int count = 0;
        
        // Try placing numbers in the m-th position...
        for (int i = 0; i < n; i++) {
            // Check if the i+1-th position is available and satisfies the divisibility condition...
            if ((mask & (1 << i)) == 0 && (m % (i + 1) == 0 || (i + 1) % m == 0)) {
                // Recursively place number m+1 at the next position and mark the current position as used...
                count += helper(m + 1, n, mask | (1 << i));
            }
        }
        
        return count;
    }
}