class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> concatenatedWords = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for(String s: words) {
            wordSet.remove(s);
            int sLength = s.length();
            boolean[] dp = new boolean[sLength + 1];
            dp[0] = true;
            for(int i=1; i<=sLength; i++) {
                for(int j=0; j<i; j++) {
                    if(dp[j] == true && wordSet.contains (s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if(dp[sLength] == true) {
                concatenatedWords.add(s);
            }
            wordSet.add(s);
        }
        return concatenatedWords;
    }
}