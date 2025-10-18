class Solution {
public:
    int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n >= 3) {
            if (presses ==  2) {
                return 7;
            } else if (presses > 2) {
                return 8;
            } else {
                return 4;
            }
        } else if (n == 1) {
          return 2;
        }  else {
            if (presses ==1) 
                return 3;
            else
               return 4;
        }
        return 0;
    }
};



// 1
// 4c1 = 4

// 2
// 4c2 + 1 = 7

// 3
// 4c3 + 4c1 = 8

// 4
// 4c2 + 4c4 + 1 = 8
 
// 5
// 4c1 + 4c3 = 8

// 6
// 4c2 + 4c4 + 1 = 8

// 7
// 4c1 + 4c3 = 8
