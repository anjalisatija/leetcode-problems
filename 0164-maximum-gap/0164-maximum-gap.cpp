class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if(nums.size()<2) return 0;
        sort(nums.begin(),nums.end());
        int maxDiff=0;
        int lo=1;
        while(lo<nums.size()){
            int currentDiff=nums[lo]-nums[lo-1];
            maxDiff=max(currentDiff,maxDiff);
            lo++;
        }
        return maxDiff;
    }
};