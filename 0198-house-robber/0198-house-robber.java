class Solution {
    public int rob(int[] nums) {
       // int oddSum=0, evenSum=0;
       int help=0, ans =0;
        for(int i : nums)
        {
            int temp=Math.max(i+help, ans);
            help=ans;
            ans=temp;
        }
        return ans;
    }
}