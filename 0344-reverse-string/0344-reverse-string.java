class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char[] reversed_s = new char[n];
        int j = 0;
        for(int i=n-1; i>=0; i--){
            reversed_s[j] = s[i];
            j++; 
        }
        for(int i=0; i<n; i++){
            s[i] = reversed_s[i];
        }
    }
}