public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lft = 0;
        while (lft < n) {
            int mid = lft + (n - lft) / 2;
            int guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess == 1) lft = mid + 1;
            else n = mid;
        }

        return lft;
    }
}