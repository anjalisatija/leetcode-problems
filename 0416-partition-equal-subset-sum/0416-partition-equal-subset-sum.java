class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0; 
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2==1){
            return false;
        }
        else{
            int s=sum/2;
            boolean dp[][]=new boolean[n+1][s+1];
            for(int i=0;i<n+1;i++){
                dp[i][0]=true;
            }
            
            for(int i=1;i<n+1;i++){
                for(int j=1;j<s+1;j++){
                  int v=nums[i-1];

                  if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                  }
                  else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                  }
                }
            }
            return dp[n][s];

        }
    }
}