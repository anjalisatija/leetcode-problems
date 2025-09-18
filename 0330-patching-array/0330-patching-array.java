class Solution {
    public int minPatches(int[] nums, int n) {
        Arrays.sort(nums); // Sort the array to process smaller numbers first
        int count = 0;      // Number of patches added
        int i = 0;          // Index to iterate through nums
        long reach = 0;     // Max number we can form with current set

        while (reach < n) {
            // If the current number extends the range (i.e., no gap)
            if (i < nums.length && nums[i] <= reach + 1) {
                reach += nums[i]; // Extend the range
                i++;              // Move to the next number
            } else {
                // Patch the array with reach+1 to close the gap
                reach += (reach + 1);
                count++;          // One more patch added
            }
        }
        return count; // Minimum number of patches required
    }
}