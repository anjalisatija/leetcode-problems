class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        String[] words = s.split(" ");

        // If the lengths don't match, return false immediately
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check if the character is already mapped to a word
            if (charToWord.containsKey(c)) {
                // If the mapping doesn't match the current word, return false
                if (!charToWord.get(c).equals(word)) return false;
            } else {
                // If the word is already mapped to a different character, return false
                if (wordToChar.containsKey(word)) {
                    if (wordToChar.get(word) != c) return false;
                }

                // Establish the new mappings
                charToWord.put(c, word);
                wordToChar.put(word, c);
            }
        }

        return true; // If all checks pass, return true
    }
}