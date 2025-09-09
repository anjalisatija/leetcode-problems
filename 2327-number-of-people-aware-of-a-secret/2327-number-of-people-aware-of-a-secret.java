class Solution {
    int mod = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        int ans = solve(1, n, delay, forget, arr);
        return ans;
    }

    int solve(int day, int n, int delay, int forget, int[] arr) {
        if (day >= n) {
            return 1;
        }

        if (arr[day] != -1) {
            return arr[day];
        }

        int ans = 1;

        for (int i = day + delay; i <= day + forget & i <= n; i++) {
            if (i == day + forget) {
                ans--;
                break;
            }

            ans = (ans + solve(i, n, delay, forget, arr)) % mod;

        }
        
        return arr[day] = ans;
    }
}