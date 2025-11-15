class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];
        pre[0] = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i - 1) == '0') {
                pre[i + 1] = i;  
            } else {
                pre[i + 1] = pre[i]; 
            }
        }
        int result = 0;
        for (int end = 1; end <= n; end++) {
            int zeroCount = (s.charAt(end - 1) == '0') ? 1 : 0;
            int pos = end;
            while (pos > 0 && zeroCount * zeroCount <= n) {
                int ones = (end - pre[pos]) - zeroCount;
                if (ones >= zeroCount * zeroCount) {
                    result += Math.min(pos - pre[pos], ones - zeroCount * zeroCount + 1);
                }
                pos = pre[pos]; 
                zeroCount++;
            }
        }
        return result;
    }
}