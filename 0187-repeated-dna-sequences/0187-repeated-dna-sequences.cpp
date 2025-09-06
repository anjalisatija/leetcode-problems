class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<string, int> sequences;
        vector<string> repeatedSeq;

        if (s.size() < 10) {
            return repeatedSeq;
        }

        for (int i = 0; i <= s.size() - 10; ++i) {
            string sequence = s.substr(i, 10);
            ++sequences[sequence];
            
            if (sequences[sequence] == 2) {
                repeatedSeq.push_back(sequence);
            }
        }

        return repeatedSeq;
    }
};