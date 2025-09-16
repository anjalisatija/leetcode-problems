class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int num : nums) {
            // Keep merging while the top of the stack is non-coprime with current number
            while (!stack.isEmpty()) {
                int top = stack.peekLast();
                int gcd = computeGCD(top, num);
                if (gcd > 1) {
                    // Merge the two using LCM and continue checking with new top
                    num = computeLCM(top, num, gcd);
                    stack.pollLast();
                } else {
                    break;
                }
            }
            stack.addLast(num);
        }

        return new ArrayList<>(stack);
    }

    // Euclidean algorithm for GCD
    private int computeGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // LCM using GCD to avoid overflow
    private int computeLCM(long a, long b, long gcd) {
        return (int) ((a * b) / gcd);
    }
}
