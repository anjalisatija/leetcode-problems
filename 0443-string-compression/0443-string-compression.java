class Solution {
    public int compress(char[] chars) {
        // Storing the index for start of same substring and modification index...
        int start = 0, count = 0, modified = 0;
        for(int i = 0; i <= chars.length; i++) {
            // While the substring has similar characters...
            if(i < chars.length && chars[start] == chars[i]) count++;
            else {
                // Shift the modification index by 1 after modifying...
                chars[modified++] = chars[start];
                if(count > 1) { // If repetition is more than once...
                    String repetition = String.valueOf(count);
                    int len = repetition.length();
                    // Updating the modification index...
                    for(int j = 0; j < len; j++)
                        chars[modified++] = repetition.charAt(j);
                }
                if(i < chars.length) {
                    // Resetting the start and the count variables...
                    start = i; count = 1;
                }
            }
        }
        return modified; // Returning the indexes modified...
    }
}