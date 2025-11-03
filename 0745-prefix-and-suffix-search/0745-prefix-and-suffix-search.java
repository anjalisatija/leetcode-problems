public class WordFilter {
    private final HashMap<String, HashSet<String>> prefixesAndSuffixesOfWords;
    private final HashMap<String, Integer> indexesOfWords;

    public WordFilter(String[] words) {
        prefixesAndSuffixesOfWords = new HashMap<>();
        indexesOfWords = new HashMap<>();
        int index = 0;
        for (String word : words) {
            String key = String.valueOf(word.charAt(0)) + word.charAt(word.length() - 1);
            if (!prefixesAndSuffixesOfWords.containsKey(key)) {
                prefixesAndSuffixesOfWords.put(key, new HashSet<>());
            }
            prefixesAndSuffixesOfWords.get(key).add(word);
            indexesOfWords.put(word, index++);
        }
    }

    public int f(String pref, String suff) {
        String key = String.valueOf(pref.charAt(0)) + suff.charAt(suff.length() - 1);
        HashSet<String> words = prefixesAndSuffixesOfWords.get(key);
        ArrayList<String> validWords = new ArrayList<>();
        int maxIndex = -1;
        if (words != null) {
            for (String word : words) {
                if (isWordStartWithPrefix(word, pref) && isWordEndWithSuffix(word, suff)) {
                    validWords.add(word);
                }
            }
            for (String str : validWords) {
                    maxIndex = Integer.max(maxIndex, indexesOfWords.get(str));
            }
        }
        return maxIndex;
    }

    private boolean isWordStartWithPrefix(String word, String pref) {
        if (pref.length() > word.length()) {
            return false;
        }
        for (int i = 0; i < pref.length(); i++) {
            if (word.charAt(i) != pref.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWordEndWithSuffix(String word, String suff) {
        if (suff.length() > word.length()) {
            return false;
        }
        StringBuilder stringBuilderWord = new StringBuilder(word);
        StringBuilder stringBuilderSuff = new StringBuilder(suff);
        String strWord = stringBuilderWord.reverse().toString();
        String strSuff = stringBuilderSuff.reverse().toString();
        return isWordStartWithPrefix(strWord, strSuff);
    }
}