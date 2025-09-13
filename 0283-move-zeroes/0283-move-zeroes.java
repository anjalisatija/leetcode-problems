class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;

        // Find the first zero in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If there is no zero in the array, return as there's nothing to move
        if (j == -1) {
            return;
        }

        // Move non-zero elements to the position of zeroes
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}