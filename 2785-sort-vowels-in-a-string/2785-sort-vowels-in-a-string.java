class Solution {
    public String sortVowels(String s) {
        List<Character> charList = new ArrayList<>();
        int indx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                    || c == 'U') {
                charList.add(c);
            }
        }
        Collections.sort(charList);
        indx = 0;
        char[] inputStr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = inputStr[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                    || c == 'U') {
                inputStr[i] = charList.get(indx++);
            }
        }
        return new String(inputStr);
    }
}