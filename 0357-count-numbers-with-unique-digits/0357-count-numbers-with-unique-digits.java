class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        // Special case for n > 10
        if (n > 10) return 0;
        
        // Initialize with single-digit numbers
        int totalCount = 10;
        int uniqueDigitsCount = 9;
        int availableDigits = 9;
        
        // Calculate for multi-digit numbers
        for (int i = 2; i <= n; i++) {
            // Multiply by available unique digits
            uniqueDigitsCount *= availableDigits;
            
            // Decrement available digits
            availableDigits--;
            
            // Add to total count
            totalCount += uniqueDigitsCount;
        }
        
        return totalCount;
    
    }
}