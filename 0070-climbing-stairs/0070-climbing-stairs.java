class Solution {
    private int[] memo;

    public int climbStairs(int n) {
        // Initialize the memoization array
        memo = new int[n + 1];
        return climbStairsHelper(n);
    }

    private int climbStairsHelper(int n) {
        // Base cases
        if (n == 1) {
            return 1; // Only one way to climb 1 step
        }
        if (n == 2) {
            return 2; // Two ways to climb 2 steps
        }

        // Check if the result is already computed
        if (memo[n] != 0) {
            return memo[n];
        }

        // Recursive call to calculate the number of ways
        memo[n] = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
        return memo[n];
    }
}