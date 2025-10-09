class Solution {
public:
    long long minTime(vector<int>& skill, vector<int>& mana) {
        int n=skill.size();
        int m=mana.size();
        vector<long long>finish(n,0);
        for(int j=0;j<m;j++)
        {
            vector<long long>prefix(n);
            prefix[0]=1LL*skill[0]*mana[j];
            for(int i=1;i<n;i++)
            {
                prefix[i]=prefix[i-1]+1LL*skill[i]*mana[j];
            }
            long long s=LLONG_MIN;
            for(int i=0;i<n;i++)
            {
                long long prev_pref=(i==0? 0LL:prefix[i-1]);
                s=max(s,finish[i]-prev_pref);
            }
            for(int i=0;i<n;i++)
            {
                finish[i]=s+prefix[i];
            }
        }
        return finish[n-1];
    }
};