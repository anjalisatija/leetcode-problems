class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0; // Counters for two potential majority elements
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE; // Potential majority elements

        // Step 1: Identify potential majority elements
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != el2) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != el1) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Verify the candidates
        cnt1 = 0; cnt2 = 0; // Reset counters
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        // Step 3: Check if the candidates appear more than n/3 times
        List<Integer> result = new ArrayList<>();
        int threshold = n / 3;
        if (cnt1 > threshold) result.add(el1);
        if (cnt2 > threshold) result.add(el2);

        return result;
    }
}