class Solution {
public:
    long long minOperations(vector<vector<int>>& queries) {
        long long ans = 0;
        for (auto& q : queries) {
            int l = q[0], r = q[1];
            long long ops_r = getOperations(r);
            long long ops_lm1 = getOperations(l - 1);
            ans += (ops_r - ops_lm1 + 1) / 2;
        }
        return ans;
    }

private:
    // Returns total floor-divide-by-4 operations needed for all x in [1, n]
    long long getOperations(int n) {
        long long res = 0;
        int ops = 0;
        for (long long p = 1; p <= n; p *= 4) {
            long long segmentStart = p;
            long long segmentEnd = min<long long>(n, p * 4 - 1);
            ++ops;
            res += (segmentEnd - segmentStart + 1) * ops;
        }
        return res;
    }
};