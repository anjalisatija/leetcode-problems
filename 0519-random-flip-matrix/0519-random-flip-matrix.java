import java.util.Random;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int rows, cols, totalCells;
    private Map<Integer, Integer> indexMap;
    private Random random;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        totalCells = rows * cols;
        indexMap = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        // Generate a random index between 0 and totalCells (exclusive)
        int randIndex = random.nextInt(totalCells--);

        // Get the original index from the map or use the random index if not present
        int originalIndex = indexMap.getOrDefault(randIndex, randIndex);

        // Update the map with the last available index and reduce totalCells
        indexMap.put(randIndex, indexMap.getOrDefault(totalCells, totalCells));

        // Convert the original index to row and column
        int row = originalIndex / cols;
        int col = originalIndex % cols;

        // Return the flipped index
        return new int[]{row, col};
    }

    public void reset() {
        // Reset the map and totalCells to their initial state
        indexMap.clear();
        totalCells = rows * cols;
    }
}