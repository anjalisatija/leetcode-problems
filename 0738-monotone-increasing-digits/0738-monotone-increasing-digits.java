class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int length = digits.length;
        
        int mark = length;
        for (int i = length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                mark = i;
                digits[i - 1]--;
            }
        }
        
        for (int i = mark; i < length; i++) {
            digits[i] = '9';
        }
        
        return Integer.parseInt(new String(digits));
    }
}