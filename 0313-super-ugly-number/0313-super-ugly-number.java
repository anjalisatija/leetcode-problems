import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Long> superUgly = new ArrayList<>();
        superUgly.add(1L);

        int[] idx = new int[primes.length];
        long[] prod = new long[primes.length];
        for (int i = 0; i < primes.length; i++) {
            prod[i] = primes[i];
        }

        while (superUgly.size() < n) {
            long nextUgly = Arrays.stream(prod).min().getAsLong();
            superUgly.add(nextUgly);

            for (int i = 0; i < primes.length; i++) {
                if (nextUgly == prod[i]) {
                    idx[i]++;
                    prod[i] = primes[i] * superUgly.get(idx[i]);
                }
            }
        }

        return superUgly.get(n - 1).intValue();
    }
}