class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //seems like should be connected to pascals triangle.
        /*
        for an edge glass = 1 on row = r, have
        for row = 1 takes poured = 1 to fill, 
        for row = 2 takes poured = 3 to fill
        for each next row, will take half of what was being poured to prev row edge glass, so will take twice as long as the prior one took to fill
        
        if look at modified pascal for time/"poured" it takes to fill a certain cup position have

                        1
                    3       3
                7       5       7
            15    25/3      25/3    15
        31     41/3

        how to get num in this triangle?

        find the two nums above it like in pascals, as those contribute via pouring
        the nums in this new triangle represent a sort of time when they start pouring if we visualize a scenario where one glass is 
        poured per second to infinity
        Then need the fraction of the total poured that goes to new pos from any of the two above once they start pouring.
        Exactly half of each of the above cups go to each below them on either side, so the fraction that goes 

        since once a cup is full, it splits what it is pouring into two different halves, 

        for q_glass = 0 row r, filled completely on poured = 2^(r+1) - 1, starts pouring on 2^r - 1 
        */
        query_glass = Math.min(query_glass, query_row-query_glass);
        if(query_row < 31 && (((1 << (query_row + 1)) - 1) <= poured)) return 1.0; //in this case, was enough to fill all in the row poured so know that glass is full regardless of pos in row
        if(query_glass == 0) return query_row > 31 || (1 << query_row) > poured ? 0.0 : (poured + 1.0)/(1 << query_row) - 1.0;
        double[][] dp = new double[query_row + 1][query_glass + 2];
        dp[0][0] = poured;

        for(int row = 0; row < query_row; row++) {
            for(int col = 0; col <= Math.min(query_glass, row); col++) {
                if(dp[row][col] <= 1.0) continue; //skip if the parent glass isn't full as won't pour any to children
                double pouredToEachChild = (dp[row][col] - 1.0)/2;
                dp[row+1][col] += pouredToEachChild;
                dp[row+1][col+1] += pouredToEachChild;
            } 
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}