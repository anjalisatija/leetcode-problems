import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // Stores the last occurrence index of each letter
        boolean[] used = new boolean[26]; // Tracks whether a letter is already in the result
        Stack<Character> stack = new Stack<>(); // Stores characters for the result

        // Store the last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character is already in the stack, skip it
            if (used[c - 'a']) continue;

            // Remove characters from stack if they are greater than the current character
            // and they appear later in the string
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                used[stack.pop() - 'a'] = false;
            }

            // Add current character to the stack and mark it as used
            stack.push(c);
            used[c - 'a'] = true;
        }

        // Convert stack to result string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    // Example Usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));  // Output: "abc"
        System.out.println(solution.removeDuplicateLetters("cbacdcbc")); // Output: "acdb"
    }
}