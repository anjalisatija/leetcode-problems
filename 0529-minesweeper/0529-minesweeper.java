class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x= click[0], y = click[1];

        //1) If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
        if(board[x][y]== 'M') {
            board[x][y] = 'X';
            return board;
        }

        if(board[x][y]== 'E') {
            int numMines = getNumberOfAdjacentMines(x,y, board);
            //If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
            if(numMines > 0) {
                board[x][y] = (char) (numMines + '0');
            } else { //2)If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B'and all of its adjacent unrevealed squares should be revealed recursively.
                board[x][y] = 'B';
                //Now making all the adjacent blocks as B.
                for(int i=x-1; i<=x+1; i++) {
                    for(int j=y-1; j<=y+1; j++) {
                        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'E'){
                            this.updateBoard(board, new int[]{i,j});
                        }
                    }        
                }
            }
        }

        return board;
    }   

    protected int getNumberOfAdjacentMines(int x, int y, char[][] board) {
        int count = 0;
        //checking all the adjacent blocks from (x-1,y), (x+1,y), (x,y-1),(x,y+1), (x+1,y+1), (x-1, y-1)
        for(int i=x-1; i <= x+1; i++) {
            for(int j=y-1; j <= y+1; j++) {
                if(i >=0  && j>= 0 && i < board.length && j < board[0].length) {
                    if(board[i][j] == 'M') {
                        count = count + 1;
                    }
                }
            }
        }

        return count;

    }
}