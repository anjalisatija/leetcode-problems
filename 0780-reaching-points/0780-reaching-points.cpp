class Solution {
public:
    bool reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }

            if (tx > ty) {
                int n = ((tx - sx)/ ty);
                if(n==0){
                    return false;
                }
                tx = tx - n * ty;
            } else {
                int n = ((ty - sy)/ tx);
                if(n==0){
                    return false;
                }
                ty = ty - n * tx;
            }
        }
        return false;
    }
};