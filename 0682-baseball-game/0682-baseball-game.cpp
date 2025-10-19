class Solution {
public:
    int calPoints(vector<string>& operations) {

        vector<int> record;
        for (string op : operations) {
            if (op == "C") {
                // Invalidate last score
                record.pop_back();
            } 
            else if (op == "D") {
                // Double last score
                record.push_back(2 * record.back());
            } 
            else if (op == "+") {
                // Sum of last two scores
                int n = record.size();
                record.push_back(record[n-1] + record[n-2]);
            } 
            else {
                // Convert string number to int
                record.push_back(stoi(op));
            }
        }
  // Calculate total score
        int score = 0;
        for (int s : record) {
            score += s;
        }

        return score;
        
    }
};