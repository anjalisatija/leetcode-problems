class Solution {
    //BRUTE FORCE APPROACH:HIT & TRIAL

// Helper method to split text into words
    private String[] multipleString(String text) {
        int n1 = text.length();
        String[] word = text.split(" ");
        return word;
    }
 // Helper method to check if a word contains any broken letters
    private boolean checker(String text, String brokenLetters) {
        int n1 = text.length();
        int n2 = brokenLetters.length();
        for (int i = 0; i < n2; i++) {
            char ch = brokenLetters.charAt(i);
            for (int j = 0; j < n1; j++) {
                if (ch == text.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] word = multipleString(text);
        int n1 = word.length;
        int n2 = brokenLetters.length();
        int count = 0;
        for (int i = 0; i < n1; i++) {
            String s = word[i];
            int n3 = s.length();
            if (checker(s, brokenLetters) == false) {
                count++;
            }
        }
        return count;
    }
}
//T(n):O(n1 * L * B)
//SC:O(n1 * L)
/*Where:
n1 = number of words in text
L = average length of a word
B = length of brokenLetters*/