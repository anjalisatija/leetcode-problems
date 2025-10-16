class Solution {
public:
    string predictPartyVictory(string senate) {
        queue<int> r;
        queue<int> d;

        int i = 0;
        for (char ch : senate) {
            if (ch == 'R') {
                r.push(i++);
            } else {
                d.push(i++);
            }
        }

        while (!r.empty() && !d.empty()) {
            if (r.front() < d.front()) {
                r.push(i++);  // R wins, reinsert at the end
            } else {
                d.push(i++);  // D wins, reinsert at the end
            }
            r.pop();
            d.pop();
        }
        
        return r.empty() ? "Dire" : "Radiant";
    }
};