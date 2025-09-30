class Solution {
public:
    int triangularSum(vector<int>& nums) {
        int n = nums.size();
        
        for(int i=1; i<=nums.size(); i++){
            n--;
            for(int i=0; i<n; i++){
                // cout<<nums[i]<<"\t"<<nums[i+1]<<endl;
                nums[i] = (nums[i]+nums[i+1])%10;  
            }
        }
        
        return nums[0];
    }
};