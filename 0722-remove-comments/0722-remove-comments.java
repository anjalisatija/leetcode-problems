import java.util.*;

class Solution {
    
    public List<String> removeComments(String[] source) {
        // Queue to store the resulting lines of code without comments
        var queue = new LinkedList<String>();
        // StringBuilder to build the current line without comments
        var temp = new StringBuilder();
        // Boolean flag to indicate if we are inside a block comment
        var blockComment = false;

        for (String line : source) {
            var lengthL = line.length();

            // Iterate through each character in the current line
            for (int i = 0; i < lengthL; i++) {
                if (blockComment) { // If inside a block comment
                    // Check if we have reached the end of the block comment
                    if (isEndOfBlock(line, lengthL, i)) {
                        blockComment = false; // Exit block comment mode
                        i++; // Skip the next character as well (end of "*/")
                    }
                } else { // If not inside a block comment
                    // Check if the current position is the start of a block comment
                    if (isStartOfBlock(line, lengthL, i)) {
                        blockComment = true; // Enter block comment mode
                        i++; // Skip the next character as well (start of "/*")
                    } else if (isLineCommentBlock(line, lengthL, i)) { // Check if it's a line comment
                        break; // Ignore the rest of the line
                    } else {
                        temp.append(line.charAt(i)); // Add the current character to temp
                    }
                }
            }

            // If not in a block comment and temp has content, add it to the result queue
            if (!blockComment && temp.length() > 0) {
                queue.add(temp.toString());
                temp.setLength(0); // Reset temp for the next line
            }
        }
        return queue; // Return the result queue containing lines without comments
    }

    // Helper method to check if the current position is the start of a line comment
    private static boolean isLineCommentBlock(String line, int lengthL, int i) {
        return i + 1 < lengthL && line.charAt(i) == '/' && line.charAt(i + 1) == '/';
    }

    // Helper method to check if the current position is the end of a block comment
    private static boolean isEndOfBlock(String line, int lengthL, int i) {
        return i + 1 < lengthL && line.charAt(i) == '*' && line.charAt(i + 1) == '/';
    }

    // Helper method to check if the current position is the start of a block comment
    private static boolean isStartOfBlock(String line, int lengthL, int i) {
        return i + 1 < lengthL && line.charAt(i) == '/' && line.charAt(i + 1) == '*';
    }
}