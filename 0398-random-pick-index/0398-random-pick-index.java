import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int[] nums;

    /**
     * Initializes the Solution object with an array of integers.
     *
     * @param nums the array of integers
     */
    public Solution(int[] nums) {
        this.nums = nums;
    }

    /**
     * Picks a random index where the target number occurs in the array.
     *
     * @param target the number to search for
     * @return a random index where the target number is found
     */
    public int pick(int target) {
       list.clear(); // Clear the list to handle multiple calls correctly
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        
        double ind = Math.random() * list.size();
        return list.get((int) ind);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */