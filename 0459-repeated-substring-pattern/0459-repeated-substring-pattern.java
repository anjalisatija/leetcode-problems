class Solution {
    public boolean repeatedSubstringPattern(String s) {
       int length = s.length();
        for (int i = 1; i <= length / 2; i++) {
            if (length % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder repeatedSubstring = new StringBuilder();
                for (int j = 0; j < length / i; j++) {
                    repeatedSubstring.append(substring);
                }
                if (repeatedSubstring.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
        
    }
}