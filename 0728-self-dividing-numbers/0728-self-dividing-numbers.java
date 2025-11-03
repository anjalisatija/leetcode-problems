class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        // Initialize a list to store self-dividing numbers
        List<Integer> result = new ArrayList<>();

        // Iterate through the range from left to right
        while(left <= right) {
            boolean isSelfDividing = true; // Flag to check if the number is self-dividing

            // Check if the number has two or more digits
            if(left >= 10) {
                int temp = left; // Temporary variable to hold the current number

                // Extract digits and check self-dividing condition
                while(temp != 0) {
                    int rem = temp % 10; // Get the last digit

                    // If the digit is 0 or not a divisor of the number, it's not self-dividing
                    if(rem == 0 || left % rem != 0) {
                        isSelfDividing = false; // Mark as not self-dividing
                        break; // Exit the loop early
                    }

                    temp /= 10; // Remove the last digit
                }
            }

            // If the number is less than 10 or is self-dividing, add it to the result list
            if(left < 10 || isSelfDividing) {
                result.add(left);
            }
            left++; // Move to the next number
        }

        // Return the list of self-dividing numbers
        return result;
    }
}