import java.util.*;

public class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false; 
        if (desiredTotal <= 0) return true;   
        return canWin(maxChoosableInteger, desiredTotal, 0, 0);
    }

    private boolean canWin(int maxChoosableInteger, int desiredTotal, int used, int currentSum) {
        if (currentSum >= desiredTotal) return false; 

        if (memo.containsKey(used)) return memo.get(used);

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            if ((used & mask) == 0) { 
                if (!canWin(maxChoosableInteger, desiredTotal, used | mask, currentSum + i)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }
        memo.put(used, false);
        return false;
    }
}