class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
        s.length() < t.length()) {
            return "";
        }

        // Character freq map for t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int required = targetMap.size();
        int formed = 0;

        // Character freq map for curr window
        Map<Character, Integer> windowMap = new HashMap<>();

        // Window pointers and result tracking
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            // Expand the window
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            // check if adding this char helps to find required pattern
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window if all character is found
            while (left <= right && required == formed) {
                c = s.charAt(left);

                // Update the result if curr window is smaller
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Remove the leftmost character from window
                windowMap.put(c, windowMap.get(c) - 1);

                // If removing this char breaks the required pattern
                if (targetMap.containsKey(c) && windowMap.get(c).intValue() < targetMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);

    }
}