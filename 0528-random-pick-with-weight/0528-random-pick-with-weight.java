import java.util.Random;
class Solution {
    /**
    1 3 3 3
     */
    int[] cumulative;
    int sum = 0;
    Random random = new Random();
    public Solution(int[] w) {
        cumulative = new int[w.length];
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            cumulative[i] = sum;
        }
    }
    
    public int pickIndex() {
        // Generate a random integer between min (inclusive) and max (inclusive)
        int randomNumber = random.nextInt(sum) + 1;
        int idx = Arrays.binarySearch(cumulative, randomNumber);
        if(idx < 0){
            idx = -idx - 1;
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */