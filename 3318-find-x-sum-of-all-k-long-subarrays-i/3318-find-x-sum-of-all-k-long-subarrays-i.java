import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        // Slide window of size k
        for (int i = 0; i <= n - k; i++) {
            // Step 1: Count occurrences in current window
            HashMap<Integer, Integer> counts = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                counts.put(nums[j], counts.getOrDefault(nums[j], 0) + 1);
            }

            // Step 2: Convert keys to list for manual sorting
            List<Integer> keys = new ArrayList<>(counts.keySet());

            // Step 3: Sort by frequency (desc), then value (desc)
            for (int a = 0; a < keys.size(); a++) {
                for (int b = a + 1; b < keys.size(); b++) {
                    int key1 = keys.get(a);
                    int key2 = keys.get(b);

                    int val1 = counts.get(key1);
                    int val2 = counts.get(key2);

                    // Higher frequency first, then higher key value
                    if (val1 < val2 || (val1 == val2 && key1 < key2)) {
                        keys.set(a, key2);
                        keys.set(b, key1);
                    }
                }
            }

            // Step 4: Keep only top x elements and sum all occurrences
            int sum = 0;
            if (keys.size() <= x) {
                // Less than x distinct elements → sum entire subarray
                for (int j = i; j < i + k; j++) {
                    sum += nums[j];
                }
            } else {
                // Only include top x elements (key * freq)
                for (int j = 0; j < x; j++) {
                    int key = keys.get(j);
                    sum += key * counts.get(key);
                }
            }

            answer[i] = sum;
        }

        return answer;
    }
}