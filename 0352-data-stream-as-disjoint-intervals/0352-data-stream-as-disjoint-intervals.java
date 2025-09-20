class SummaryRanges {

    private TreeSet<Integer> nums;

    public SummaryRanges() {
        nums = new TreeSet<>();
    }

    public void addNum(int value) {
        nums.add(value);
    }

    public int[][] getIntervals() {
        if (nums.isEmpty()) {
            return new int[0][0];
        }

        List<int[]> intervals = new ArrayList<>();
        int start = -1;
        int end = -1;

        for (int num : nums) {
            if (start == -1) {
                start = num;
                end = num;
            } else if (num == end + 1) {
                end = num;
            } else {
                intervals.add(new int[]{start, end});
                start = num;
                end = num;
            }
        }
        intervals.add(new int[]{start, end}); // Add the last interval

        int[][] result = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); i++) {
            result[i] = intervals.get(i);
        }

        return result;
    }
}