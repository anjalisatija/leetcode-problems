class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charFrequency = new int[26];

        s.chars().forEach(ch -> charFrequency[ch - 'a']++);
        t.chars().forEach(ch -> charFrequency[ch - 'a']--);

        for (int frequency : charFrequency) {
            if (frequency != 0) return false;
        }

        return true;
    }
}