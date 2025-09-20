class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        // Populate the map with the frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a priority queue (min-heap) to keep track of the top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>(Map.Entry.comparingByValue());

        // Add entries to the priority queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll(); // Remove the entry with the smallest frequency
            }
        }

        // Extract keys from the priority queue and store them in the ans array
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().getKey();
        }

        return ans; // Return the array of top k frequent elements
    }
    
}