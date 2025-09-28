class Solution {
    public String frequencySort(String s) {
        // Create a HashMap to store character frequency
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Create a priority queue to sort characters based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        // Add all characters to the priority queue
        maxHeap.addAll(frequencyMap.keySet());
        
        // Build the sorted string
        StringBuilder sortedString = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString();
        
    }
}