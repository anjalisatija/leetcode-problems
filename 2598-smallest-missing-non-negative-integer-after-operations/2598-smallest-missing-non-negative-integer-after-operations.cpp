class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        std::vector<int> mapper(value + 1);
        for (int x : nums) {
            ++mapper[((x % value) + value) % value];
        }
    
        int num{};
        while (mapper[num % value] > 0) {
            --mapper[num % value];
            ++num;
        }

        return num;
    }
};