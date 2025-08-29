public class Solution {
    public int[] plusOne(int[] digits) {
        // Start from the last element and move backwards
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // If the digit is less than 9, just increment and return the result
                digits[i]++;
                return digits;
            }
            // Otherwise, set the current digit to 0 and carry over 1 to the next digit
            digits[i] = 0;
        }

        // If we finished the loop, it means all digits were 9
        // So we need to add 1 at the beginning of a new array
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1; // The rest will be 0 by default
        return newDigits;
    }
}