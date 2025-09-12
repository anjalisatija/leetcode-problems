class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        if (nums == null || k < 0) {
            return new int[0];
        }
        int n = nums.length;
        int result[] = new int[n - k + 1];
        int result_idx = 0;
        for (int i = 0; i < n; i++) {
            // If the current index is outside of the window, remove it
            while (q.size() > 0 && q.peek() < i - k + 1) {
                q.poll();
            }
            // if previous greter index is lesser then current added index so remove the
            // index
            while (q.size() > 0 && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // Add the current index to the queue
            q.offer(i);
            // If we have processed at least k elements, record the maximum for the window
            if (i >= k - 1) {
                result[result_idx++] = nums[q.peek()];
            }
        }
        return result;
    }
}