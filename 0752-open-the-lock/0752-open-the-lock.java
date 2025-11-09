class Solution {
    // Possible directions to turn a digit: +1 (forward) or -1 (backward)
    int[] DIRS = {1, -1};

    public int openLock(String[] deadends, String target) {
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        // If the initial state is in deadends, return -1 immediately
        if (deadSet.contains("0000")) return -1;

        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process the current level (BFS approach)
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // If we reach the target, return the number of moves
                if (current.equals(target)) return steps;

                // Try all possible wheel rotations for each of the 4 digits
                for (int index = 0; index < 4; index++) {
                    for (int dir : DIRS) {
                        // Compute new digit (handling wrap-around with mod 10)
                        int newDigit = (current.charAt(index) - '0' + dir + 10) % 10;

                        // Generate the new combination by modifying the current digit
                        String newCombination = current.substring(0, index) +
                                                newDigit +
                                                current.substring(index + 1);

                        // If it's neither visited nor a deadend, add to queue
                        if (!visited.contains(newCombination) && !deadSet.contains(newCombination)) {
                            visited.add(newCombination);
                            queue.offer(newCombination);
                        }
                    }
                }
            }
            steps++; // Increase step count after processing one level
        }
        return -1; // If BFS completes and we never reached the target
    }
}