class Solution {
    public boolean isSubsequence(String s, String t) {
        // s --> "a b c" --> i;
        // t --> "a h b g d c" --> j;
        int i = 0, j = 0;
        // Iterate through both strings
        while(i < s.length() && j < t.length()){
             // If characters match, move the pointer for s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move the pointer for t
            j++;
        }
        // If i is equal to the length of s, all characters of s were found in t
        return i == s.length();
    }
}