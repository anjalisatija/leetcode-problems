class Solution {

    public int[][] memo;
    public int[] nums1;
    public int[] nums2;
    public int n;

    public int minSwap(int[] nums1, int[] nums2) {
        n = nums1.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new int[n][2];
        for(int[]a : memo) Arrays.fill(a, -1);

        return solve(0, 0);
    }

    public int solve(int i, int s){
        if(i==n) return 0;
        if(memo[i][s] != -1) return memo[i][s];

        int prev1 = (i==0) ? -1 : (s==1 ? nums2[i-1] : nums1[i-1]);
        int prev2 = (i==0) ? -1 : (s==1 ? nums1[i-1] : nums2[i-1]);

        int min = Integer.MAX_VALUE;

        //no swap if sorted
        if(nums1[i] > prev1 && nums2[i] > prev2){
            min = Math.min(min, solve(i+1, 0));
        }

        if(nums2[i] > prev1 && nums1[i] > prev2){
            min = Math.min(min, 1 + solve(i+1, 1));
        }

        return memo[i][s] = min; 
    }
}