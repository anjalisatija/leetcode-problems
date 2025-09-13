class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowel = new HashMap<>();
        HashMap<Character, Integer> consonants = new HashMap<>();
        String str = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            if (str.contains(Character.toString(s.charAt(i)))) {
                vowel.put(s.charAt(i), vowel.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                consonants.put(s.charAt(i), consonants.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        int m1 = 0;
        for (Map.Entry<Character, Integer> entry : vowel.entrySet()) {
            if (vowel.get(entry.getKey()) > m1) {
                m1 = vowel.get(entry.getKey());
            }
        }
        int m2 = 0;
        for (Map.Entry<Character, Integer> entry : consonants.entrySet()) {
            if (consonants.get(entry.getKey()) > m2) {
                m2 = consonants.get(entry.getKey());
            }
        }
        return m1 + m2;
    }
}