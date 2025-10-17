class Solution {
public:
    Solution(){
        ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    }
    vector<vector<int>> imageSmoother(vector<vector<int>>& grid) {
        int n=grid.size(), m=grid[0].size();
        vector<vector<int>> newgrid(grid);
        for(int i = 0; i<n; i++)
            for(int j=0; j<m; j++)
            {
                int cnt=0, sum{};
                for(int ii=i-1; ii<i+2; ii++)
                    for(int jj=j-1; jj<j+2; jj++)
                        if(ii>=0 && ii<n && jj>=0 && jj<m)
                            sum+=grid[ii][jj], cnt++;
                newgrid[i][j]=sum/cnt;
            }
        return newgrid;
    }
};