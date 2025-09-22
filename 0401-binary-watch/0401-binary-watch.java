class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int h = 0; h < 4; h++) {
            int m = turnedOn - h;
            if (m < 0 || m > 6) continue; // Skip invalid minute combinations
            
            List<Integer> hours = getValidTimes(h, 4, 11);  // Hours: 0 to 11
            List<Integer> minutes = getValidTimes(m, 6, 59); // Minutes: 0 to 59
            
            for (int hour : hours) {
                for (int minute : minutes) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        
        return result;
    }

    private List<Integer> getValidTimes(int turnedOnBits, int totalBits, int maxVal) {
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < (1 << totalBits); i++) {
            if (Integer.bitCount(i) == turnedOnBits && i <= maxVal) {
                values.add(i);
            }
        }

        return values;
    }
}