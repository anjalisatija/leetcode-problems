class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc_end = new int[n];
        int[] inc_strt = new int[n];

        for(int i = 0; i < n; i++){
            inc_end[i] = 1;
            inc_strt[i] = 1;
        }

        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(i - 1)){
                inc_end[i] = inc_end[i - 1] + 1;
            }
        }

        for(int i = n - 2; i>= 0; i--){
            if(nums.get(i) < nums.get(i + 1)){
                inc_strt[i] = inc_strt[i + 1] + 1;
            }
        }

        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            int k = Math.min(inc_end[i], inc_strt[i+1]);
            ans = Math.max(ans,k);
        }

        return ans;
    }
}