class Solution {
public:
    int edg=0;
    void dfs(vector<int> adj[], int node, vector<int>&vis){
        vis[node]=1;

        for(auto s : adj[node]){
            if(!vis[s]){
                dfs(adj,s,vis);
                edg++; // count the edge
            }
        }
    }
    int minSwapsCouples(vector<int>& row) {
        int n = row.size();

        for(int i=0;i<n;i++){
            row[i]/=2;
        }

        vector<int> adj[n];

        for(int i=0;i<n;i+=2){
            if(row[i]==row[i+1]) continue; // couples are sitting together

            adj[row[i]].push_back(row[i+1]);
            adj[row[i+1]].push_back(row[i]);
        }
        vector<int> vis(n,0);

        for(int i=0;i<n;i++){
            if(!vis[i]) dfs(adj,i,vis);
        }
        return edg;
        
    }
};