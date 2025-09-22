import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> maxF = new HashMap<>();
        int n = nums.length;

        // Calculate frequency of each element
        for (int i = 0; i < n; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        int maxFreq = 0;
        int count = 0;

        // Iterate through frequencies to find the maximum frequency
        for (int freq : frequency.values()) {
            maxF.put(freq, maxF.getOrDefault(freq, 0) + 1);
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        // Calculate the count of elements with the maximum frequency
        for (int x : maxF.keySet()) {
            if (maxFreq == x) {
                count = x * maxF.get(x);
            }
        }

        return count;
    }
}