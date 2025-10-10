class Solution:
    def findIntegers(self, n: int) -> int:
        # Convert n to binary
        binary_n = bin(n)[2:]
        
        # Initialize dp array to store the count of valid binary representations of length i
        dp = [0] * (len(binary_n) + 1)
        
        # Initialize base cases
        dp[0] = 1  # Empty string is a valid binary representation
        dp[1] = 2  # "0" and "1" are valid
        
        # Build the dp array
        for i in range(2, len(dp)):
            dp[i] = dp[i - 1] + dp[i - 2]
        
        # Count the valid representations for n
        count = 0
        prev_bit = 0
        
        for i in range(len(binary_n)):
            if binary_n[i] == '1':
                count += dp[len(binary_n) - i - 1]
                if prev_bit == 1:
                    count -= 1  # Subtract 1 for the case where two consecutive 1s are encountered
                    break
                prev_bit = 1
            else:
                prev_bit = 0
        
        return count + 1  # Add 1 for the binary representation of n itself