class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target); // Work with the absolute value of target
        int step = 0;
        int sum = 0;

        // Find the minimum step such that sum >= target and (sum - target) is even
        while (true) {
            sum += step;
            if (sum >= target && (sum - target) % 2 == 0) {
                return step;
            }
            step++;
        }
    }
}