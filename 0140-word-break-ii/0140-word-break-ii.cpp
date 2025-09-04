class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        unordered_set<string> wordDictSet(wordDict.begin(), wordDict.end());  // Use a set for O(1) lookups
        
        // DP array to store sentences from index i
        vector<vector<string>> sentencesStartingFrom(n + 1);
        sentencesStartingFrom[n] = {""}; // Base case: empty string leads to an empty sentence

        // Iterate backwards to build up sentences
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j <= n; ++j) {
                string word = s.substr(i, j - i);
                if (wordDictSet.find(word) != wordDictSet.end()) {
                    for (const string& suffix : sentencesStartingFrom[j]) {
                        sentencesStartingFrom[i].push_back(suffix.empty() ? word : word + " " + suffix);
                    }
                }
            }
        }

        return sentencesStartingFrom[0];
    }
};