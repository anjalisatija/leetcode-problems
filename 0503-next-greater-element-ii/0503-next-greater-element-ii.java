class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currInd = i % n;
            while (!st.isEmpty() && st.peek() <= nums[currInd]) {
                st.pop();
            }

            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[currInd]);

        }
        return nge;
    }
}