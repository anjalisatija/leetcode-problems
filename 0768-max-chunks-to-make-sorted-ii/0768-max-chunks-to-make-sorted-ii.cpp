class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int chunk_counter = 0;
        vector<int> leftmax(arr.size() + 1);
        vector<int> rmin(arr.size() + 1);
        int minval = INT_MAX; // Corrected from MAX_INT
        int maxVal = INT_MIN; // Renamed from leftmax
        rmin[arr.size()] = minval;
        for (int i = arr.size() - 1; i >= 0; i--) {
            rmin[i] = min(rmin[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.size(); i++) {
            maxVal = max(maxVal, arr[i]);
            if (maxVal <= rmin[i + 1]) {
                chunk_counter++;
            }
        }

        return chunk_counter;
    }
};
