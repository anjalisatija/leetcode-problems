class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        unordered_map<char,int>freq;
        for(int i=0;i<stones.length();i++){
            char num=stones[i];
            freq[num]++;
        }
        int total=0;
        for(int i=0;i<jewels.length();i++){
            char c=jewels[i];
            total+=freq[c];
        }
        return total;


    }
};