import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort the envelopes in ascending order of width and descending order of height
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return b[1] - a[1];
        });

        // Initialize an array to store the LIS of heights
        int[] lis = new int[envelopes.length];
        int len = 0;

        // Traverse the envelopes and use binary search to find the LIS
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(lis, 0, len, envelope[1]);
            if (index < 0)
                index = -(index + 1);
            lis[index] = envelope[1];
            if (index == len)
                len++;
        }

        return len;
    }
}