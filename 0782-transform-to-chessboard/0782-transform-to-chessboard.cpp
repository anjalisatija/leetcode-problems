class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        int n = board.size();
        int firstRowMatch = 1, secondRowMatch = 0, firstColMatch = 1, secondColMatch = 0;

        for (int i = 1; i < n; i++) {
            if (board[0][i] == board[0][0]) {
                firstRowMatch++;
                for (int j = 1; j < n; j++) {
                    if (board[j][i] != board[j][0]) return -1;
                }
            } else {
                secondRowMatch++;
                for (int j = 1; j < n; j++) {
                    if (board[j][i] == board[j][0]) return -1;
                }
            }

            if (board[i][0] == board[0][0]) {
                firstColMatch++;
                for (int j = 1; j < n; j++) {
                    if (board[i][j] != board[0][j]) return -1;
                }
            } else {
                secondColMatch++;
                for (int j = 1; j < n; j++) {
                    if (board[i][j] == board[0][j]) return -1;
                }
            }
        }

        if (abs(firstRowMatch - secondRowMatch) > 1 || abs(firstColMatch - secondColMatch) > 1) return -1;

        int rowMismatch = 0, colMismatch = 0;
        for (int i = 0; i < n; i++) {
            if (board[0][i] != i % 2) rowMismatch++;
            if (board[i][0] != i % 2) colMismatch++;
        }

        int rowMismatch2 = n - rowMismatch, colMismatch2 = n - colMismatch;
        int totalMoves = 0;

        if (rowMismatch2 % 2) totalMoves += rowMismatch / 2;
        else if (rowMismatch % 2) totalMoves += rowMismatch2 / 2;
        else totalMoves += min(rowMismatch, rowMismatch2) / 2;

        if (colMismatch2 % 2) totalMoves += colMismatch / 2;
        else if (colMismatch % 2) totalMoves += colMismatch2 / 2;
        else totalMoves += min(colMismatch, colMismatch2) / 2;

        return totalMoves;
    }
};