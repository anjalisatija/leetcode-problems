import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        TreeSet<long[]> xMaxFrequencyElement = new TreeSet<>(
                (a, b) -> {
                    if (a[1] == b[1]) {
                        return Long.compare(a[0], b[0]);
                    }
                    return Long.compare(a[1], b[1]);
                }
        );
        TreeSet<long[]> remainingElementNotPresentInXMaxFrequencyElement = new TreeSet<>(
                (a, b) -> {
                    if (a[1] == b[1]) {
                        return Long.compare(b[0], a[0]);
                    }
                    return Long.compare(b[1], a[1]);
                }
        );
        Map<Integer, long[]> frquencyCountMap = new HashMap<>();
        long[] result = new long[nums.length - k + 1];
        long sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            long[] curr = frquencyCountMap.getOrDefault(nums[i], new long[2]);

            if (xMaxFrequencyElement.contains(curr)) {
                sum -= curr[0] * curr[1];
                xMaxFrequencyElement.remove(curr);
            } else {
                remainingElementNotPresentInXMaxFrequencyElement.remove(curr);
            }
            curr[0] = nums[i];
            curr[1]++;
            frquencyCountMap.put(nums[i], curr);
            remainingElementNotPresentInXMaxFrequencyElement.add(curr);
            if (j + k - 1 == i) {
                while (xMaxFrequencyElement.size() < x && !remainingElementNotPresentInXMaxFrequencyElement.isEmpty()) {
                    long[] next = remainingElementNotPresentInXMaxFrequencyElement.pollFirst();
                    sum += next[1] * next[0];
                    xMaxFrequencyElement.add(next);
                }
                result[j] = sum;
                long[] last = frquencyCountMap.get(nums[j]);
                if (xMaxFrequencyElement.contains(last)) {
                    sum -= last[0] * last[1];
                    xMaxFrequencyElement.remove(last);
                } else {
                    remainingElementNotPresentInXMaxFrequencyElement.remove(last);
                }
                last[1]--;
                if (last[1] > 0) {
                    frquencyCountMap.put(nums[j], last);
                    remainingElementNotPresentInXMaxFrequencyElement.add(last);
                } else {
                    frquencyCountMap.remove(nums[j]);
                }
                if (!xMaxFrequencyElement.isEmpty()) {
                    long[] min = xMaxFrequencyElement.pollFirst();
                    sum -= min[0] * min[1];
                    remainingElementNotPresentInXMaxFrequencyElement.add(min);
                }
                j++;
            }
        }
        return result;
    }
}