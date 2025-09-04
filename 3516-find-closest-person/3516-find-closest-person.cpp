class Solution {
public:
    int findClosest(int x, int y, int z) {
        int dist1 = abs(x - z); // Distance from Person 1 to Person 3
    int dist2 = abs(y - z); // Distance from Person 2 to Person 3

    if (dist1 < dist2) return 1;
    else if (dist2 < dist1) return 2;
    else return 0;
    }
};