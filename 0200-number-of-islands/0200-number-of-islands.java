class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        if(grid==null || grid.length==0){  //Handling all the edge cases
            return 0;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    count++;
                    DFS(grid,i,j);
                }
            }
        }
        return count;
    }
    public void DFS(char[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';     //Marking as visted
        DFS(grid,r+1,c);    //Going right
        DFS(grid,r-1,c);    //Going left
        DFS(grid,r,c+1);    //Going down
        DFS(grid,r,c-1);    //Going up
    }
}