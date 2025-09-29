import java.util.HashMap;
import java.util.Map;
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;
        int s1Count = 0, s2Count = 0, s2Index = 0;
        Map<Integer, int[]> recall = new HashMap<>();
        while (s1Count < n1) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(s2Index)) {
                    s2Index++;
                    if (s2Index == s2.length()) {
                        s2Count++;
                        s2Index = 0;
                    }
                }
            }
            s1Count++;
            if (recall.containsKey(s2Index)) {
                int[] previous = recall.get(s2Index);
                int prevS1Count = previous[0];
                int prevS2Count = previous[1];
                
                int cycleLength = s1Count - prevS1Count;
                int cycleS2Count = s2Count - prevS2Count;
                
                int remainingCycles = (n1 - s1Count) / cycleLength;
                
                s1Count += remainingCycles * cycleLength;
                s2Count += remainingCycles * cycleS2Count;
            } else {
                recall.put(s2Index, new int[]{s1Count, s2Count});
            }
        }
        return s2Count / n2;
    }
}