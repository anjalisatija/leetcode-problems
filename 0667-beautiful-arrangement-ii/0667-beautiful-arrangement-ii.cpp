class Solution {
public:
    vector<int> constructArray(int n, int k) {
        vector<int> result;
        int left = 1, right = n;

        // Construct the first part of the array with k distinct differences
        for (int i = 0; i < k; ++i) {
            if (i % 2 == 0) {
                result.push_back(left++);  // Pick from the start of the range
            } else {
                result.push_back(right--);  // Pick from the end of the range
            }
        }

        // Fill the remaining part with a simple increasing sequence
        if (k % 2 == 0) {
            for (int i = right; i >= left; --i) {
                result.push_back(i);
            }
        } else {
            for (int i = left; i <= right; ++i) {
                result.push_back(i);
            }
        }

        return result;
    }
};

