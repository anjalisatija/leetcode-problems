class MagicDictionary {
    unordered_map<int, vector<string>> wordsByLength;
public:
    MagicDictionary() {}
    
    void buildDict(vector<string> dictionary) {
        for (auto& word : dictionary) {
            wordsByLength[word.size()].push_back(word);
        }
    }
    
    bool search(string searchWord) {
        int n = searchWord.size();
        for (auto& word : wordsByLength[n]) {
            int mismatch = 0;
            for (int i = 0; i < n; i++) {
                if (searchWord[i] != word[i]) {
                    if (++mismatch > 1) break;
                }
            }
            if (mismatch == 1) return true;
        }
        return false;
    }
};