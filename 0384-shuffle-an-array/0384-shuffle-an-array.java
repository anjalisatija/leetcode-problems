class Solution {
    int[] original;
    Random random;
    public Solution(int[] nums) {
        original = nums.clone();
        random = new Random();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        int[] shuffled = original.clone();
        int len = shuffled.length;
        for (int i = len - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = shuffled[j];
            shuffled[j] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */