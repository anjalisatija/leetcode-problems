class Solution {
    public int characterReplacement(String s, int k) {
        // Frequency map for characters A-Z
        int[] map = new int[26];
        int res = 0;
        int max = 0;

        // Sliding window pointers
        int l = 0;

        // Traverse the string with the right pointer
        for (int r = 0; r < s.length(); r++) {
            // Update the frequency of the current character
            map[s.charAt(r) - 'A']++;

            // Track the maximum frequency character in the window
            max = Math.max(max, map[s.charAt(r) - 'A']);

            // Check if window is valid; if not, shrink it from the left
            if (r - l + 1 - max > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }

            // Update the result with the maximum window size found so far
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}