class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort the people array in descending order of height (h) and ascending order of k
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> reconstructedQueue = new ArrayList<>();
        
        // Insert each person into the reconstructed queue at the index specified by their k value
        for (int[] person : people) {
            reconstructedQueue.add(person[1], person);
        }
        
        // Convert the list to a 2D array and return
        return reconstructedQueue.toArray(new int[reconstructedQueue.size()][]);    
    }
}