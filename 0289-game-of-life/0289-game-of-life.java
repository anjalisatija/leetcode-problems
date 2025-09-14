public class Solution {
    // Function to Check whether Neighbor is there and Live or NOT for a particular Co-Ordinates
    public int isNeighborLive(int[][] board, int m, int n, int row, int col) {
        if ((row >= 0 && row < m) && (col >= 0 && col < n) && board[row][col] == 1)
            return 1;
        return 0;
    }

    // Function to Count the No. of Live Neighbor Cells
    public int countLiveNeighbor(int[][] board, int m, int n, int row, int col) {
        return (
            // Upper Row
            isNeighborLive(board, m, n, row-1, col-1) +
            isNeighborLive(board, m, n, row-1, col) +
            isNeighborLive(board, m, n, row-1, col+1) +
            // Current Row
            isNeighborLive(board, m, n, row, col-1) +
            isNeighborLive(board, m, n, row, col+1) +
            // Lower Row
            isNeighborLive(board, m, n, row+1, col-1) +
            isNeighborLive(board, m, n, row+1, col) +
            isNeighborLive(board, m, n, row+1, col+1)
        );
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] nextState = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int liveNeighbors = countLiveNeighbor(board, m, n, row, col);
                // Matrix or Array have 0 by Default
                // so Updating the Next State Matrix with 1 only
                if (board[row][col] == 0) {
                    if (liveNeighbors == 3)
                        nextState[row][col] = 1;
                } else {
                    if (liveNeighbors == 2 || liveNeighbors == 3)
                        nextState[row][col] = 1;
                }
            }
        }
        // Copying the Next State to the given Board
        for (int i = 0; i < m; i++)
            board[i] = nextState[i].clone();
    }
}