class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) count[ch-'a']++;
        StringBuilder sb = new StringBuilder();
        for(char ch : order.toCharArray()){
            while(count[ch-'a']>0){
                sb.append(ch);
                count[ch-'a']--;
            }
        }

        for(char ch='a';ch<='z';ch++){
            while(count[ch-'a']>0){
                sb.append(ch);
                count[ch-'a']--;
            } 
        }

        return new String(sb);
    }
}