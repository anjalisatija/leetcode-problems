class Solution {
private:
    unordered_map<long long, int> mp;
    string S;
    int K;
    int solve(long long i, long long uniqueChar, bool canChange) {

        long long key = (i << 27) | (uniqueChar << 1) | canChange;

        if (mp.find(key) != mp.end())
            return mp[key];

        if (i >= S.length())
            return 0;

        int charIndex = S[i] - 'a';
        int newUniqueChars = uniqueChar | 1 << charIndex;
        int newUniqueCharCnt = __builtin_popcount(newUniqueChars);

        int result;
        if (newUniqueCharCnt > K) {
            result = 1 + solve(i + 1, (1 << charIndex), canChange);
        } else {
            result = solve(i + 1, newUniqueChars, canChange);
        }

        if (canChange == true) {
            for (int newCharIndex = 0; newCharIndex < 26; newCharIndex++) {
                int newCharSet = uniqueChar | (1 << newCharIndex);
                int newUniqueCharCount = __builtin_popcount(newCharSet);
                if (newUniqueCharCount > K) {
                    result = max(result,
                                 1 + solve(i + 1, (1 << newCharIndex), false));
                } else {
                    result = max(result, solve(i + 1, newCharSet, false));
                }
            }
        }
        return mp[key] = result;
    }

public:
    int maxPartitionsAfterOperations(string s, int k) {
        S = s, K = k;
        return 1 + solve(0, 0, true);
    }
};