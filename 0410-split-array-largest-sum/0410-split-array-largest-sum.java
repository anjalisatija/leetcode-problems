import java.util.*;

class Solution {
    public int splitArray(int[] nums, int k) {
        int left =0;
        int right =0;
        for(int n : nums){
            left = Math.max(left , n);
            right +=n;
        }

        while(left <= right){
            int mid =left + (right -left) /2;
            if(isPossible(nums , k , mid)){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return left;
    }
    public boolean isPossible(int[] nums , int k , int min){
        int sum=0;
        int len=1;
        for(int i=0 ; i< nums.length; i++){
            if(sum + nums[i] > min){
                len++;
                sum = nums[i];
                if(len > k){
                    return false;
                }
            }else{
                sum += nums[i];
            }
        }
        return true;
    }
}