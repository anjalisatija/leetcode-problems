class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 2; i < n;i++){
            int a = 0;
            int b = i-1;
            while(a < b){
               if(nums[a] + nums[b] > nums[i]){
                ans = ans + b - a;
                b--;
            } else{
                a++;
            }
          }
        }
        return ans ;
    }
}