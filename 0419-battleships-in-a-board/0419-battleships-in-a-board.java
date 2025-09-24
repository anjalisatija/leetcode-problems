class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        if(rows == 0) return 0;
        int columns = board[0].length;
        if(columns == 0) return 0;
        int i,j,left,top;
        int total =0;
        for(i =0; i <rows; i++){
            top = i -1;
            for(j =0; j<columns ; j ++){
                left = j-1;
                if(board[i][j] == 'X' && (left <0 || board[i][left] == '.') && (top <0 || board[top][j] == '.')){
                    total++;
                }
            }
        }
        return total;
    }
}