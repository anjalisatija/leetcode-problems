class Solution {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }

        // Initialize the dp array to store maximum products.
        int[] dp = new int[n + 1];

        // Base case: dp[2] = 1
        dp[2] = 1;

        for (int i = 3; i<= n; i++) {
            // Initialize the maximum product as 0 for the current number.
            int maxProduct = 0;

            // Break the current number into two integers j and i-j.
            // Calculate the product of these two integers and update maxProduct.
            for (int j = 1; j < i; j++) {
                maxProduct = Math.max(maxProduct, Math.max(j * (i - j), j * dp[i - j]));
            }

            // Update dp[i] with the maximum product.
            dp[i] = maxProduct;
        }

        return dp[n];
    }
}