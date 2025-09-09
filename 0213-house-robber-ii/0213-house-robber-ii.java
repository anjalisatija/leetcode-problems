class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int[] first = new int[nums.length-1];
        int[] second = new int[nums.length-1];
        for (int i = 0; i < first.length; i++) {
            first[i] = nums[i];
            second[i] = nums[i+1];
        }
        int ans1 = robDP(first);
        int ans2 = robDP(second);
        return Math.max(ans1,ans2);
    }
    public static int robDP(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curri = Math.max(prev,nums[i]+prev2);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}