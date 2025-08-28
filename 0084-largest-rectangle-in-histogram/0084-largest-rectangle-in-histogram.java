public class Solution {
    public int largestRectangleArea(int[] heights) {
        // Stack to store indices of the bars
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate through each bar
        for (int i = 0; i < n; i++) {
            // While the current bar is smaller than the bar represented by the top of the stack
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()]; // Get the height of the bar
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1; // Calculate the width
                maxArea = Math.max(maxArea, h * w); // Calculate area and update maxArea
            }
            stack.push(i); // Push the current bar's index onto the stack
        }

        // Calculate the area for remaining bars in the stack
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = (stack.isEmpty()) ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }
}