import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // two arrays (0-index) -> no need to adjust: nums1, nums2
        // nums2 contains nums1 elements.
        // output: array ans of length nums1 (subset) where each element is the next greater element in nums2 of each element in nums1.
        // if no next greater element: return -1

        // example inputs: 
        // nums1 = [4, 1, 2]
        // nums2 = [1, 3, 4, 2]

        // example output:
        // ans = [-1, 3, -1]

        HashMap<Integer, Integer> nextGreater = new HashMap<Integer, Integer>(); // stores the next greater element
        int[] ans = new int[nums1.length];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > nums2[i]) {
                    nextGreater.put(nums2[i], stack.peek());
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                nextGreater.put(nums2[i], -1);
            }

            stack.push(nums2[i]);
        }

        // At this point, our HashMap is filled with our required values.
        for (int j = 0; j < nums1.length; j++) {
            ans[j] = nextGreater.get(nums1[j]);
        }

        return ans;
    }
}