import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        
        // Count frequency of each task
        for (char task : tasks) {
            frequency[task - 'A']++;
        }
        
        // Sort tasks based on frequency
        Arrays.sort(frequency);
        
        // Get the maximum frequency
        int maxFreq = frequency[25];
        
        // Calculate idle intervals
        int idleIntervals = (maxFreq - 1) * n;
        
        // Fill in idle intervals with remaining tasks
        for (int i = 24; i >= 0 && idleIntervals > 0; i--) {
            idleIntervals -= Math.min(maxFreq - 1, frequency[i]);
        }
        
        // If there are still idle intervals left, add them to the total intervals required
        idleIntervals = Math.max(0, idleIntervals);
        
        // Return the maximum of either the total intervals required or the total number of tasks
        return tasks.length + idleIntervals;
    }
}