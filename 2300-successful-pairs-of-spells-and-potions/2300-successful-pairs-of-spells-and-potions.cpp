class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
         sort(potions.begin(), potions.end());
        int m = potions.size();
        vector<int> res;
        
        for (long long spell : spells) {
            // Minimum potion strength required
            long long minPotion = (success + spell - 1) / spell; // ceil(success / spell)
            
            // Find first potion >= minPotion
            auto it = lower_bound(potions.begin(), potions.end(), minPotion);
            
            // Count of successful pairs for this spell
            int count = potions.end() - it;
            res.push_back(count);
        }
        
        return res;
    }
};