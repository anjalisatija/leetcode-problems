class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        
        // Try each unique character count as the target
        for (int uch = 1; uch <= 26; uch++) {
            int left = 0, right = 0;
            int[] fre = new int[26];  // Frequency array
            int unc = 0, vc = 0;  // Unique count and valid count
            
            while (right < s.length()) {
                if (unc <= uch) {
                    // Expand window
                    int ch = s.charAt(right) - 'a';
                    if (fre[ch] == 0) {
                        unc++;  // New unique character
                    }
                    fre[ch]++;  // Increment frequency
                    if (fre[ch] == k) {
                        vc++;  // Character becomes valid
                    }
                    right++;
                } else {
                    // Shrink window
                    int ch = s.charAt(left) - 'a';
                    if (fre[ch] == k) {
                        vc--;  // Character no longer valid
                    }
                    fre[ch]--;
                    if (fre[ch] == 0) {
                        unc--;  // Unique character removed
                    }
                    left++;
                }
                
                // Check valid window
                if (uch == unc && unc == vc) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}