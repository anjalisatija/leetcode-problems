#include <vector>
#include <queue>
#include <algorithm>
#include <set>

using namespace std;

class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int, int>> events;  // {x-coordinate, height}
        
        for (const auto& building : buildings) {
            events.emplace_back(building[0], -building[2]);  // Start of the building
            events.emplace_back(building[1], building[2]);  // End of the building
        }
        
        // Sort events
        sort(events.begin(), events.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            if (a.first != b.first) return a.first < b.first;  // Sort by x-coordinate
            return a.second < b.second;  // Sort starts (-height) before ends (+height)
        });
        
        multiset<int> heights = {0};  // Max-heap to store building heights
        vector<vector<int>> result;
        int prev_max_height = 0;

        for (const auto& [x, h] : events) {
            if (h < 0) {
                // Building starts: Add height to the heap
                heights.insert(-h);
            } else {
                // Building ends: Remove height from the heap
                heights.erase(heights.find(h));
            }
            
            // Get the current maximum height
            int current_max_height = *heights.rbegin();
            if (current_max_height != prev_max_height) {
                // Height changed, add a key point
                result.push_back({x, current_max_height});
                prev_max_height = current_max_height;
            }
        }
        
        return result;
    }
};