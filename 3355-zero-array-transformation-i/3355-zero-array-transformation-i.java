class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n  = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int li = query[0], ri = query[1];
            diff[li] += 1;
            if (ri + 1 < n) {
                diff[ri + 1] -= 1;
            }
        }

        int decrement = 0;
        for (int i = 0; i < n; i++) {
            decrement += diff[i];
            if (decrement < nums[i]) {
                return false;
            }
        }
        return true;
    }
}