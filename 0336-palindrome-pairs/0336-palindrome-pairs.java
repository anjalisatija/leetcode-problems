class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> soln = new ArrayList<>();
        List<Integer> wordsPair = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();

        for (int i=0; i<words.length; i++)
            wordsMap.put(words[i], i);

        for (int i=0; i<words.length; i++) {
            if (wordsMap.containsKey("") && !words[i].equals("") && isPalindrome(words[i])) {
                soln.add(Arrays.asList(wordsMap.get(""), wordsMap.get(words[i])));
                soln.add(Arrays.asList(wordsMap.get(words[i]), wordsMap.get("")));
            }

            StringBuilder sb = new StringBuilder(words[i]);
            String revStr = sb.reverse().toString();

            if (wordsMap.containsKey(revStr) && !words[i].equals(revStr))
                soln.add(Arrays.asList(wordsMap.get(words[i]), wordsMap.get(revStr)));

            for (int j=1; j<words[i].length(); j++) {
                String prefix = revStr.substring(0, j);
                String suffix = revStr.substring(j);

                if (isPalindrome(prefix) && wordsMap.containsKey(suffix))
                    soln.add(Arrays.asList(i, wordsMap.get(suffix)));
                if (isPalindrome(suffix) && wordsMap.containsKey(prefix))
                    soln.add(Arrays.asList(wordsMap.get(prefix), i));
            }
        }
        return soln;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}