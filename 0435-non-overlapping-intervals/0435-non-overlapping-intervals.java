import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // number of non-overlapping intervals
        int end = Integer.MIN_VALUE;

        // Step 2: Greedily select non-overlapping intervals
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                count++;           // Keep this interval
                end = interval[1]; // Update end to current interval's end
            }
        }

        // Step 3: Total intervals - non-overlapping = intervals to remove
        return intervals.length - count;
    }
}