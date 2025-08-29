class Solution {
    public long flowerGame(int n, int m) {
        long nOdd = (n + 1) / 2; // odds from 1..n
        long nEven = n / 2;      // evens from 1..n
        long mOdd = (m + 1) / 2; // odds from 1..m
        long mEven = m / 2;      // evens from 1..m

        // Alice wins if (x+y) is odd
        return nOdd * mEven + nEven * mOdd;
    }
}