class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
		int[] bitmasks = new int[n];
		int[] lengths = new int[n];

		for (int i = 0; i < n; i++) {
			String word = words[i];
			int bitmask = 0;
			for (char c : word.toCharArray()) {
				bitmask |= 1 << (c - 'a');
			}
			bitmasks[i] = bitmask;
			lengths[i] = word.length();
		}

		int maxProduct = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((bitmasks[i] & bitmasks[j]) == 0) {
					maxProduct = Math.max(maxProduct, lengths[i] * lengths[j]);
				}
			}
		}

		return maxProduct;
    }
}