class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ei = 0, lgei = 0, lastNumValidSi = 0;
        int ans = 0;
        while (ei < nums.length) {
            if (nums[ei] > right) {
                // not a valid end index, so skip
                lgei = ei + 1;
                lastNumValidSi = 0;
            } else if (nums[ei] <= right && nums[ei] >= left) {
                // valid ei
                int numOfValidSi = ei - lgei + 1;
                ans += numOfValidSi;
                lastNumValidSi = numOfValidSi;
            } else {
                // arr[ei] < left. still valid
                ans += lastNumValidSi;
            }
            ei++;
        }
        return ans;
    }
}