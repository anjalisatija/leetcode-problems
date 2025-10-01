class Solution {
    // Map to store the memory table...
    Map<String, Integer> memory = new HashMap<>();
  
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    public int helper(int nums[], int i, int target) {
        if(i == nums.length)    // Base case, if the target can be made or not...
            return target == 0 ? 1 : 0;
        
        // If already computed we do not redefine them...
        String key = i + "|" + target;      // Key to define the states...
        if(memory.containsKey(key))  return memory.get(key);
        
        // When we give a + sign to the current number...
        int addWays = helper(nums, i + 1, target - nums[i]);
        // When we give a - sign to the current number...
        int removeWays = helper(nums, i + 1, target + nums[i]);
        
        // Total number of ways from both signs...
        memory.put(key, addWays + removeWays);
        return memory.get(key);     // Updating and returning state memory...
    }

    public int recurse(int nums[], int i, int target) {
        if(i == nums.length)        // Base case when target formed...
            return target == 0 ? 1 : 0;
        
        // When we give a + sign to the number...
        int addWays = recurse(nums, i + 1, target - nums[i]);
        // When we give a - sign to the number...
        int removeWays = helper(nums, i + 1, target - nums[i]);
        
        return addWays + removeWays;
    }
}