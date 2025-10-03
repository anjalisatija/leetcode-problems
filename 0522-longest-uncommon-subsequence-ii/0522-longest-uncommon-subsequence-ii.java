class Solution {
    public int findLUSlength(String[] strs) {
        int maxLength = -1;
        
        // Iterate through each string in the array
        for (int i = 0; i < strs.length; i++) {
            boolean isUnique = true;
            
            // Compare the current string with all other strings
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUnique = false;
                    break;
                }
            }
            
            // If it is unique and its length is greater than the current maxLength
            if (isUnique) {
                maxLength = Math.max(maxLength, strs[i].length());
            }
        }
        
        return maxLength;
    }

    // Helper function to check if str1 is a subsequence of str2
    private boolean isSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }
}