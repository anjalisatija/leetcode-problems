class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        int sLen = s.length();

        // Create an array of lists to store words by their first characters
        List<String>[] wordLists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            wordLists[i] = new ArrayList<>();
        }

        // Populate wordLists with words indexed by their first character
        for (String word : words) {
            wordLists[word.charAt(0) - 'a'].add(word);
        }

        // Iterate through string s
        for (char c : s.toCharArray()) {
            List<String> currentWords = wordLists[c - 'a'];
            wordLists[c - 'a'] = new ArrayList<>();

            for (String word : currentWords) {
                if (word.length() == 1) {
                    count++; // Word is a subsequence of s
                } else {
                    wordLists[word.charAt(1) - 'a'].add(word.substring(1)); // Remove the first character
                }
            }
        }

        return count;
    }
}