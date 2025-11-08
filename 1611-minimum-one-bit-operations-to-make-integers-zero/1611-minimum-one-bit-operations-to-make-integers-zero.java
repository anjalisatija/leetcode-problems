class Solution {
    public int minimumOneBitOperations(int n) {
         for (int i = 1; i < 32; i <<= 1)
            n ^= n >> i;
        return n;

    }
}