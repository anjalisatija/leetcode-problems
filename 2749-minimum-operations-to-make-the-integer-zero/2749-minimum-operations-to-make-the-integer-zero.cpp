class Solution {
public:
    int makeTheIntegerZero(int num1, int num2) {
        for (long ops = 0; ops <= 60; ++ops) {
            long target = num1 - ops * num2;
            // Check if target >= ops and popcount(target) ≤ ops
            if (target >= ops && __builtin_popcountl(target) <= ops) {
                return (int)ops;
            }
        }
        return -1;
    }
};