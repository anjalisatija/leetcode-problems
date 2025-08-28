class Solution {
public:
    std::vector<std::vector<int>> sortMatrix(std::vector<std::vector<int>>& grid) {
        int n = grid.size();
        std::map<int, std::vector<int>> bottom_diags, top_diags;
        
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (r >= c) {
                    bottom_diags[r - c].push_back(grid[r][c]);
                } else {
                    top_diags[r - c].push_back(grid[r][c]);
                }
            }
        }
        
        for (auto& pair : bottom_diags) {
            std::sort(pair.second.rbegin(), pair.second.rend());
        }
        
        for (auto& pair : top_diags) {
            std::sort(pair.second.begin(), pair.second.end());
        }
        
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (r >= c) {
                    grid[r][c] = bottom_diags[r - c].front();
                    bottom_diags[r - c].erase(bottom_diags[r - c].begin());
                } else {
                    grid[r][c] = top_diags[r - c].front();
                    top_diags[r - c].erase(top_diags[r - c].begin());
                }
            }
        }
        
        return grid;
    }
};