class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean inSegment = false;

        for (char c : s.toCharArray()) {
            if (c != ' ' && !inSegment) {
                count++; // Start of a new segment
                inSegment = true;
            } else if (c == ' ') {
                inSegment = false; // End of current segment
            }
        }
        return count;
    }
}