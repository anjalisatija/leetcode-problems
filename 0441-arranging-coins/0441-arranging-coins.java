class Solution {
    public int arrangeCoins(int n) {
        int row =0;
        int coinsLeft=n;
        while(true){
            coinsLeft=coinsLeft-row;
            row++;

            if(coinsLeft<row){
                break;
            }

           
        }
         return row-1;
}
}