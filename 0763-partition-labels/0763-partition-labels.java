class Solution {
    public List<Integer> partitionLabels(String s) {
         List<Integer> result = new ArrayList<>();
        
        // Step 1: Store the last occurrence of each character
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }
        
        // Step 2: Partition the string
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndexMap.get(s.charAt(i))); // Extend the partition if needed
            
            if (i == end) { // Found a valid partition
                result.add(end - start + 1);
                start = i + 1; // Move to the next partition
            }
        }
        
        return result;
    }
}