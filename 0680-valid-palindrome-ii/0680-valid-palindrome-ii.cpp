class Solution {
public:
    bool isPalindromeRange(const string& s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    bool validPalindrome(string s) {
        int start = 0, end = s.size() - 1;

        while (start < end) {
            if (s[start] != s[end]) {
                // Try skipping one character: either start or end
                return isPalindromeRange(s, start + 1, end) || isPalindromeRange(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true;
    }
};