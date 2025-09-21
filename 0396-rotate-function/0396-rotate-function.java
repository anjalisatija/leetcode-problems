class Solution {
    public int maxRotateFunction(int[] nums) {
        int f0 = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            f0 += (nums[i] * i);
            sum += nums[i];
        }
        int res = f0;
        for (int i = 1; i < nums.length; i++) {
            f0 += sum - nums.length * (nums[nums.length - i]);
            res = Math.max(res, f0);
        }
        return res;
    }
}