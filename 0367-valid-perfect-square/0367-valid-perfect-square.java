class Solution {
    public boolean isPerfectSquare(int num) {
        long lft = 1, rgt = num;
        while (lft < rgt) {
            long mid = (lft + rgt) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid > num) rgt = mid;
            else lft = mid + 1;
        }
        
        return num == 1;
    }
}