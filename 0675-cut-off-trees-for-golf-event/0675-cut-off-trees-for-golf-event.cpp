class Solution {
public:
    int m, n;

    // BFS to find shortest path from (sx,sy) to (tx,ty)
    int bfs(vector<vector<int>>& f, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;
        vector<vector<int>> visited(m, vector<int>(n, false));
        queue<pair<int,int>> q;
        q.push({sx, sy});
        visited[sx][sy] = true;
        int step = 0;
        vector<pair<int,int>> dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.empty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();
                for (auto [dx, dy] : dir) {
                    int nx = x + dx, ny = y + dy;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        !visited[nx][ny] && f[nx][ny] != 0) {
                        if (nx == tx && ny == ty) return step;
                        visited[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
            }
        }
        return -1; // unreachable
    }

    int cutOffTree(vector<vector<int>>& f) {
        m = f.size();
        n = f[0].size();

        // collect all trees
        vector<tuple<int,int,int>> trees; // {height, x, y}
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (f[i][j] > 1) {
                    trees.push_back({f[i][j], i, j});
                }
            }
        }

        // sort by height
        sort(trees.begin(), trees.end());

        int totalSteps = 0;
        int cx = 0, cy = 0; // start at (0,0)

        for (auto [h, tx, ty] : trees) {
            int dist = bfs(f, cx, cy, tx, ty);
            if (dist == -1) return -1;
            totalSteps += dist;
            cx = tx; cy = ty;
            f[tx][ty] = 1; // cut the tree
        }

        return totalSteps;
    }
};