class Solution {
public:
    map<string, int> mp;

    bool solve(string s ,map<string,int>&mp,vector<vector<int>>& dp, int index, string temp){
        if(index==s.size()){
            if(temp=="" || mp[temp]==1) return true;
            return false;
        }
        int x = temp.size();
        if(dp[index][x] != -1) return dp[index][x];
        temp += s[index];
        if(mp[temp] == 1){
            return dp[index][x] = solve(s, mp, dp, index+1, temp) || solve(s, mp, dp, index+1,"");
        }
        return dp[index][x] = solve(s, mp, dp, index+1,temp);
    }

    bool wordBreak(string s, vector<string>& wordDict) {
        map<string,int>mp;
        for(string s:wordDict)mp[s]=1;
        vector<vector<int>>dp(s.size(),vector<int>(s.size()+1,-1));
        return solve(s, mp, dp, 0, "");
    }
};