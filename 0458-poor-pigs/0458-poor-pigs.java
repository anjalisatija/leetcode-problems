public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Calculate the number of rounds possible
        int rounds = minutesToTest / minutesToDie;
        
        // Now find the minimum number of pigs such that the number of outcomes is >= buckets
        int pigs = 0;
        
        // We need (2^rounds) ^ pigs >= buckets
        while (Math.pow(rounds + 1, pigs) < buckets) {
            pigs++;
        }
        
        return pigs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        System.out.println(solution.poorPigs(4, 15, 15));  // Output: 2
        
        // Test case 2
        System.out.println(solution.poorPigs(4, 15, 30));  // Output: 2
    }
}