class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        int n = s.size();
        unordered_set<string> vis;
        queue<string> q;
        q.push(s);
        string ans = s;
        while(!q.empty())
        {
            string temp = q.front();
            q.pop();
            if(vis.count(temp))
            continue;
            vis.insert(temp);

            ans = min(ans, temp);
            string s1 = temp;
            for(int i = 1; i < s1.size(); i += 2)
            {
                s1[i] = (s1[i] - '0' + a) % 10 + '0';
            }
            string s2 = temp.substr(temp.size() - b) + temp.substr(0, temp.size()-b);
            q.push(s1);
            q.push(s2);
        }
        return ans;
    }
};