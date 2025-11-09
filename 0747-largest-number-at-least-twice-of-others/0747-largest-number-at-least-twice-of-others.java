class Solution {
    public int dominantIndex(int[] nums) {
        
        int max = -1;
        int secondmax = -1;
        int maxindex = 0;

        for(int i = 0; i < nums.length; i++){

            if(max < nums[i]){
                secondmax = max;
                max = nums[i];
                maxindex = i;

            }else if(secondmax < nums[i]){
                secondmax = nums[i];
            }
        }
        if(secondmax * 2 <= max){
            return maxindex;
        }
        else{
            return -1;
        }
    }
}