class Solution {
public:
int Win(vector<int>& nums,int s,int e)
{
    if(s==e)
    {
        return nums[s];
    }

    //choose first element
    int x=nums[s]-Win(nums,s+1,e);

    //choose last element
    int y=nums[e]-Win(nums,s,e-1);

    return max(x,y);
}

bool predictTheWinner(vector<int>& nums) {
    int n=nums.size();
    int ans=Win(nums,0,n-1);
    if(ans>=0)
    {
        return true;
    }
    return false;
  }
};