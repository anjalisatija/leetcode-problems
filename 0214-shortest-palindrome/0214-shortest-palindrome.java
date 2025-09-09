class Solution {
    public static boolean check(String s){
        int i=0;
        int j=s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String shortestPalindrome(String s) {
        int idx=-1;
        for(int i=s.length();i>=0;i--){
            if(check(s.substring(0,i))){
                idx=i;
                break;
            }
        }
        if(idx==s.length()){
            return s;
        }
        String help_str= "";
        for(int i=s.length()-1;i>=idx;i--){
            help_str+=s.charAt(i);
        }
        return help_str+s;
    }
}