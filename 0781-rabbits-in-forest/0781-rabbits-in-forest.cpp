class Solution {
public:
    int numRabbits(vector<int>& answers) {
        int totalRabbits = 0; // Initialize the total number of rabbits.
        map<int, int> countMap; // Map to track the count of each unique answer.

        // Count the frequency of each distinct answer.
        for (int answer : answers) {
            countMap[answer]++;
        }

        // Calculate the minimum number of rabbits based on the collected answers.
        for (auto& [answer, count] : countMap) {
            // 'answer + 1' represents the group size (same colored rabbits).
            // Calculate the number of such groups needed using integer division rounding up.
            // Multiply by the group size to get the total number of rabbits for this answer.
            totalRabbits += (answer + 1) * ((count + answer) / (answer + 1));
        }

        return totalRabbits;
    }
};