class Solution {
    public int countValidSelections(int[] nums) {
        int left = 0, right = 0, ans = 0;
        
        // Compute the initial sum of the array (right sum)
        for (int i : nums) {
            right += i;
        }

        // Iterate through each index in the array
        for (int i = 0; i < nums.length; i++) {
            // Check if nums[i] == 0 (valid starting position)
            if (nums[i] == 0) {
                // Case 1: Both directions are valid
                if (left == right) {
                    ans += 2;
                }
                // Case 2: Only one direction is valid
                if (Math.abs(left - right) == 1) {
                    ans += 1;
                }
            } else {
                // Update left and right sums for the next index
                left += nums[i];
                right -= nums[i];
            }
        }
        return ans;
    }
}