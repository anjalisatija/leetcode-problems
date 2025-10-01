class Solution {
    public String[] findWords(String[] words) {
        String[] keys = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList<>();

        for (String word : words) {
            for (String key : keys) {
                if (matchWord(word, key).equals(word.toLowerCase())) {
                    result.add(word);
                }
            }
        }
        return result.toArray(String[]::new);
    }

    public String matchWord(String word, String key) {
        char[] wordArr = word.toCharArray();
        List<String> matchedKeys = IntStream.range(0, wordArr.length).mapToObj(x -> String.valueOf(wordArr[x]).toLowerCase()).filter(key::contains).toList();
        return String.join("", matchedKeys);
    }
}