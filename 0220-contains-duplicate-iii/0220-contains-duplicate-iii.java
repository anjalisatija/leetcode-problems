// YouTube Link --> https://www.youtube.com/watch?v=DUPwzvuI4vQ
class Solution {
    // TC : O(N * log(indexDiff)) & SC : O(min(N, indexDiff))
    // N ->  Length of the array 'nums'
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // Write your code here
        // Use a TreeSet 'set' to maintain a sliding window of elements
        TreeSet < Long > set = new TreeSet < > ();
        // Traverse the array 'nums' using a loop
        for (int i = 0; i < nums.length; i++) {
            // |(nums[i] - nums[j])| <= valueDiff, means -->
            // (nums[i] - nums[j]) <= valueDiff --> nums[i] <= (nums[j] + valueDiff)
            // (nums[i] - nums[j]) >= -valueDiff --> nums[i] >= (nums[j] - valueDiff)
            // For each element, find the floor value and ceiling value using the 'floor' and 'ceiling' methods of TreeSet 'set'
            Long floor = set.floor(1L * nums[i] + valueDiff);
            Long ceil = set.ceiling(1L * nums[i] - valueDiff);
            // Check if the floor value is not null and satisfies the condition '(nums[i] <= floor)',
            // Or if the ceiling value is not null and satisfies the condition '(nums[i] >= ceil)'.
            if (floor != null && nums[i] <= floor || ceil != null && nums[i] >= ceil) {
                // If any of these conditions are met, return 'true'
                return true;
            }
            // After processing each element, add it to the TreeSet 'set'
            set.add(1L * nums[i]);
            // If the size of the TreeSet 'set' exceeds 'indexDiff', remove the oldest element from the TreeSet 'set'
            if (i >= indexDiff) {
                set.remove(1L * nums[i - indexDiff]);
            }
        }
        // If no valid pair of indices is found during the entire traversal, return 'false'
        return false;
    }
}