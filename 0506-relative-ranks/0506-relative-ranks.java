public class Solution {
    /**
     * Relative Ranks - You are given an integer array score of size n, where score[i] is the score of the ith
     * athlete in a competition. All the scores are guaranteed to be unique.
     *
     * The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place
     * athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
     *
     * The 1st place athlete's rank is "Gold Medal".
     * The 2nd place athlete's rank is "Silver Medal".
     * The 3rd place athlete's rank is "Bronze Medal".
     * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's
     * rank is "x").
     * Return an array answer of size n where answer[i] is the rank of the ith athlete.
     *
     * Example 1:
     * Input: score = [5,4,3,2,1]
     * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
     * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
     * 
     * Example 2:
     * Input: score = [10,3,8,9,4]
     * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
     * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
     *
     * Constraints:
     * n == score.length
     * 1 <= n <= 10^4
     * 0 <= score[i] <= 10^6
     * All the values in score are unique.
     */
    public String[] findRelativeRanks(int[] scores) {

        // Encode the index (0-9999) into the score (0-1_000_000_000)
        for (int i = 0; i < scores.length; i++) {
            scores[i] = -scores[i] * 10000 - i; // shifts score left, makes room for index
        }
        // Sort in ascending order (the highest absolute score is first, since scores are negated )
        Arrays.sort(scores);

        // Gather the places (first place first)
        final String[] ret = new String[scores.length];
        for (int i = 0; i < ret.length; i++) {
            final int index = -scores[i] % 10000; // decode index
            if (i > 2) { // test most common case first
                ret[index] = Integer.toString(i + 1);
            } else if (i == 2) {
                ret[index] = "Bronze Medal";
            } else if (i == 1) {
                ret[index] = "Silver Medal";
            } else {
                ret[index] = "Gold Medal";
            }
        }
        return ret;
    }
}