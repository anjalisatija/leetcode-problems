public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        // Fill leftMin array
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        }
        
        // Fill rightMax array
        rightMax[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }
        
        // Check for the condition
        for (int j = 1; j < n-1; j++) {
            if (leftMin[j-1] < nums[j] && nums[j] < rightMax[j+1]) {
                return true;
            }
        }
        
        return false;
    }
}