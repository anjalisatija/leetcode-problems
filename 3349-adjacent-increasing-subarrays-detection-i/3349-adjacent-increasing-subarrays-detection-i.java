class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int prev = nums.get(i);
            while (j < n && j - i < k && nums.get(j) > prev) {
                prev = nums.get(j);
                j++;
            }
            if (j - i == k) {
                if (set.contains(i - k))
                    return true;
                set.add(i);
            }
        }
        return false;
    }
}