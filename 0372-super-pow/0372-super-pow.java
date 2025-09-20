class Solution {
    public int superPow(int a, int[] b) {
        int ans = 1;
        a = a % 1337;
        for (int i = 0; i < b.length; i++) {
            ans = pow(ans, 10) * pow(a, b[i]) % 1337;
        }
        return ans;
    }
    
    private int pow(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x % 1337;
        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
    }
}