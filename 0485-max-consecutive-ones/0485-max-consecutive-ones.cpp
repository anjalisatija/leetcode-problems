class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int ans = 0;
        int maxans = 0;
        int n = nums.size();
        
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                ans++;
                maxans = max(maxans, ans);
            }else{
               ans = 0;
        }
        } 
        return maxans;
    }
};