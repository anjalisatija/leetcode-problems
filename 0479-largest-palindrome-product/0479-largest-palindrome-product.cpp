class Solution {
public:
    int largestPalindrome(int n) {
        if (n == 1) return 9; // The largest palindrome from two 1-digit numbers is 9.

        int upper = pow(10, n) - 1; // Largest n-digit number.
        int lower = upper / 10 + 1; // Smallest n-digit number is upper / 10 + 1.

        for (int i = upper; i >= lower; --i) {
            // Construct the palindrome by converting `i` to string and appending its reverse to itself.
            long long candidate = buildPalindrome(i);

            // Check if there are two n-digit numbers whose product equals the candidate palindrome.
            for (long long j = upper; j * j >= candidate; --j) {
                if (candidate % j == 0 && candidate / j <= upper) {
                    return candidate % 1337;
                }
            }
        }

        return -1; // If no palindrome is found, which is theoretically impossible for n >= 1.
    }

private:
    long long buildPalindrome(int half) {
        string s = to_string(half);
        reverse(s.begin(), s.end());
        return stoll(to_string(half) + s);
    }
};