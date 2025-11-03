public class Solution {
    public int MinCost(string colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.Length;

        for (int i = 1; i < n; i++) {
            if (colors[i] == colors[i - 1]) {
                totalTime += Math.Min(neededTime[i], neededTime[i - 1]);

                neededTime[i] = Math.Max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTime;
    }
}