
class Solution {
    public int lengthOfLIS(int[] nums) {
        // List to store the smallest possible end elements of increasing subsequences
        List<Integer> lis = new ArrayList<>();

        // Iterate through the input array
        for (int num : nums) {
            // Find the position where num can be placed (or replaced) in the lis list
            int pos = binarySearch(lis, num);

            // If the position is equal to the size of lis, we append the num (new
            // subsequence length)
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                // Otherwise, replace the element at the found position
                lis.set(pos, num);
            }
        }

        // The size of lis represents the length of the longest increasing subsequence
        return lis.size();
    }

    // Helper method to perform binary search
    private int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}