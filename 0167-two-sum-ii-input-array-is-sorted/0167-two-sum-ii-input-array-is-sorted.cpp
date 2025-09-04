class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) 
    {
        int t = numbers.size()-1;
        int i = 0;
        while(numbers[i]+numbers[t]!=target)
        {
            if(numbers[i]+numbers[t]<target)
            i++;
            else if(numbers[i]+numbers[t]>target)
            t--;
        }
        i++;
        t++;
        vector<int> ans;
        ans.push_back(i);
        ans.push_back(t);
        return ans;
    }
};