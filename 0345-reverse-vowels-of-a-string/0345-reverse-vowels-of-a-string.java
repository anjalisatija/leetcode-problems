class Solution {
    public String reverseVowels(String s) {
        String m = "";
        String temp="";
        for (int i = s.length() - 1; i >= 0; i--) {
            char conv = s.charAt(i);
            temp+=conv;
            if (temp.equalsIgnoreCase("a") || temp.equalsIgnoreCase("e") || temp.equalsIgnoreCase("i")
                    || temp.equalsIgnoreCase("o") || temp.equalsIgnoreCase("u")) {
                m += temp;
            }
            temp="";
        }
        int j = 0;
        StringBuilder string1 = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char conv = s.charAt(i);
            temp+=conv;
            if (temp.equalsIgnoreCase("a") || temp.equalsIgnoreCase("e") || temp.equalsIgnoreCase("i")
                    || temp.equalsIgnoreCase("o") || temp.equalsIgnoreCase("u")) {
                string1.setCharAt(i, m.charAt(j));
                j++;
            }
            temp="";

        }
        return string1.toString();
    }
}