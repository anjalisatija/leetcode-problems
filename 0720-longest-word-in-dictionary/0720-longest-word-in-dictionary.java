class Solution {
    public String longestWord(String[] words) {
        // Sort the word lexicographically
        Arrays.sort(words);

        //Use a HashSet to store valid words
        HashSet<String> validWords = new HashSet<>();
        String longestWord = "";

        //Add an empty string to the set (base case)
        validWords.add("");

        for(String word : words) {
            // Check if the prefix ( word without the last character ) exists in the set
            if(validWords.contains(word.substring(0, word.length() - 1 ))) {
                // Add the word to the set as it can be built
                validWords.add(word);

                //update the longest word if necessary 
                if(word.length() > longestWord.length() || 
                (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)){
                    longestWord = word;
                }
            } 
        }
        return longestWord;
    }
}