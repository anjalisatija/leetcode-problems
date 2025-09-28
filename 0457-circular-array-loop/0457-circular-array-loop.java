import java.util.Arrays;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] hash = new boolean[n];
        boolean[] circle = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hash[i]) {
                Arrays.fill(circle, false);
                hash[i] = circle[i] = true;
                int index = i;
                while (true) {
                    int t = index + nums[index];
                    t %= n;
                    if (t < 0) {
                        t += n;
                    }

                    if (nums[t] * nums[i] < 0) {
                        break;
                    }

                    if (index == t) {
                        hash[t] = circle[t] = true;
                        break;
                    }

                    if (circle[t]) {
                        return true;
                    } else {
                        hash[t] = circle[t] = true;
                    }

                    index = t;
                }
            }
        }
        return false;
    }
}