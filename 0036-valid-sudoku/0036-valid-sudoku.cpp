#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // Create 9 sets for rows, columns, and 3x3 sub-boxes to track seen numbers
        vector<unordered_set<char>> rows(9), cols(9), boxes(9);

        // Traverse each cell in the 9x9 Sudoku board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c]; // Get the current cell value

                // Skip empty cells
                if (num == '.') continue;

                // Calculate the index of the 3x3 sub-box
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check if the number already exists in the row, column, or sub-box
                if (rows[r].count(num) || cols[c].count(num) || boxes[boxIndex].count(num)) {
                    return false; // If duplicate is found, return false
                }

                // Insert the number into the corresponding row, column, and sub-box sets
                rows[r].insert(num);
                cols[c].insert(num);
                boxes[boxIndex].insert(num);
            }
        }

        // If no conflicts were found, the board is valid
        return true;
    }
};