class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ptri;
        ptri.push_back({1});

        for(int i = 1; i < numRows; i++) {
            vector<int> temp;
            vector<int>& prevRow = ptri[i - 1];

            temp.push_back(1); // First element is always 1

            for(int j = 1; j < i; j++) {
                // Sum of two elements above
                temp.push_back(prevRow[j - 1] + prevRow[j]);
            }

            temp.push_back(1); // Last element is always 1
            ptri.push_back(temp);
        }

        return ptri;
    }
};