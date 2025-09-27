class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int count = 0;
        
        // Iterate through each point
        for (int i = 0; i < n; i++) {
            // Create a HashMap to store the distance counts
            Map<Integer, Integer> distanceCount = new HashMap<>();
            
            // Iterate through all other points to calculate distances
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int distance = calculateDistance(points[i], points[j]);
                    distanceCount.put(distance, distanceCount.getOrDefault(distance, 0) + 1);
                }
            }
            
            // For each count in the HashMap, calculate the number of boomerangs
            for (int dCount : distanceCount.values()) {
                count += dCount * (dCount - 1); // For each pair of points with the same distance, there are dCount * (dCount - 1) boomerangs
            }
        }
        
        return count;
    }
    
    // Calculate the squared distance between two points
    private int calculateDistance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}