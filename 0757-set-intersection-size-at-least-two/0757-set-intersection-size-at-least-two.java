class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int length = intervals.length;
        int result = 2;

        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        int largestValue = intervals[0][1];
        int secondLargestValue = intervals[0][1] - 1;

        for (int i = 1; i < length; i++) {
            int intervalStart = intervals[i][0], intervalEnd = intervals[i][1];

            if (intervalStart > largestValue) {
                result += 2;
                largestValue = intervalEnd;
                secondLargestValue = intervalEnd - 1;
            } else if (intervalStart > secondLargestValue && intervalStart <= largestValue) {
                result += 1;
                secondLargestValue = largestValue;
                largestValue = intervalEnd;
            }
        }

        return result;
    }
}