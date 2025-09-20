class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp=new Integer[target+1];
        dp[0]=1;
        return combinate(nums,target,dp);
    }

    public int combinate(int[] nums,int target,Integer[] dp){
        if((dp[target])!=null) return dp[target];
        
        int res=0;
        for(int n:nums){
            if(target-n>=0){
            res+=combinate(nums,target-n,dp);
            }
        }
        dp[target]=res;
        return res;
    }
}