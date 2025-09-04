class Solution {
public:
    int titleToNumber(string columnTitle) {
        int columnNumber = 0, len = columnTitle.size();

        for (int i = 0; i < len; i++) 
        {
            int a = (columnTitle[i] - 'A') + 1;
            columnNumber = (26 * columnNumber) + a;
        }

        return columnNumber;
    }
};