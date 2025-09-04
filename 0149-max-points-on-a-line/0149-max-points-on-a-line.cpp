class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int ans = 0;
        int n = points.size();
        
        for(int i = 0; i < n; i++) {
            map<double, int> slope_count;
            for(int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                
                double slope;
                
                // Handle vertical line case (where x coordinates are the same)
                if(points[j][0] == points[i][0]) {
                    slope = std::numeric_limits<double>::infinity(); // Infinite slope
                } else {
                    slope = (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);
                }
                
                slope_count[slope]++;
            }
            
            // Find the max number of points with the same slope for this point
            int max_points_on_line = 0;
            for(auto it : slope_count) {
                max_points_on_line = max(max_points_on_line, it.second);
            }
            
            // Update the global max (adding 1 to include the point itself)
            ans = max(ans, max_points_on_line);
        }
        
        // Since each line contains at least one point (i itself)
        return ans + 1;
    }
};