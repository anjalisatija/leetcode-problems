class Solution {
public:
    bool checkBip(int x, vector<vector<int>>& graph, vector<int> &vis, vector<int> &col)
    {
        if(vis[x])
            return true;
        int parCol = col[x],ch;
        vis[x] = 1;
        int i,len = graph[x].size();
        for(i=0;i<len;i++)
        {
            ch = graph[x][i];
            if(vis[ch] == 1 && col[ch] == col[x])
                return false;
            if(!vis[ch])
            {
                col[ch] = (col[x] == 1 ? 2 : 1);
                if(!checkBip(ch,graph,vis,col))
                    return false;
            }
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size(),i;
        if(n <= 2)
            return true;
        
        bool flag = true;
        vector<int> vis(n,0);
        vector<int> col(n,0);
        
        col[0] = 1;
        for(i=0;i<n;i++)
        {
            if(!vis[i])
            {
                col[i] = 1;
                flag = checkBip(i,graph,vis,col);
                if(flag == false)
                    return false;
            }
        }
        return true;
    }
};