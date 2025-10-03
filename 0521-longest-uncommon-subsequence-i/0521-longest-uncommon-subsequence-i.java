class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1; // If both strings are equal, no uncommon subsequence exists
        else
            return Math.max(a.length(), b.length()); // Return the length of the longer string
    }
}