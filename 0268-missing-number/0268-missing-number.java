class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
       int i,sum=0;
       for(i=0; i<n; i++){
          sum= sum+ nums[i];
       }

       return n*(n+1)/2 - sum;
       
    }
}