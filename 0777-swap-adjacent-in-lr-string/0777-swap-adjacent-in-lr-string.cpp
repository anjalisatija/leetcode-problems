class Solution {
public:
    bool canTransform(string start, string result) {
        string s1 = "", s2 = "";
        vector<int> l1, l2;
        int cnt1 = 0, cnt2 = 0;
        
        // Remove 'X' and store X before index
        for(char c : start) {
            if(c != 'X') {
                s1 += c;
                l1.push_back(cnt1);
            } else {
                cnt1++;
            }
        }

        for(char c : result) {
            if(c != 'X') {
                s2 += c;
                l2.push_back(cnt2);
            } else {
                cnt2++;
            }
        }

        // Condition 1: Order should match
        if (s1 != s2) return false;

        // Condition 2 & 3: Valid movement of 'L' and 'R'
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] == 'L' && l2[i] > l1[i]) return false;
            if (s1[i] == 'R' && l2[i] < l1[i]) return false;
        }
        
        return true;
    }
};