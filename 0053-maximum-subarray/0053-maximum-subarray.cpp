class Solution {
public:
    int maxSubArray(vector<int>& nums) {
    
    if(nums.empty())
       return 0;
    
    int sum=nums[0],max_sum=sum;
    int ans[2]={0,0};

    int i=0;
    for(int j=1;j<nums.size();j++)
    {   
        if(sum<0)
         {  sum=0;
             i=j;
             
         }

        sum=sum+nums[j];

        if(sum>max_sum)
        {  max_sum=sum; 
           ans[0]=i;
           ans[1]=j;
         } 
    }

      cout<<"starting position of array with max sum is "<<ans[0]<<" and end position is "<<ans[1];
      return max_sum;
    }   
    
    
};