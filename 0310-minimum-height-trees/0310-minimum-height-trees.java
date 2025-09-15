class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            // If there's only one node, return it as the root
            return Collections.singletonList(0);
        }

        // Create an adjacency list to represent the graph
        List<Set<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Initialize leaves queue with nodes that have only one neighbor
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        // Repeat removing leaves until there are one or two nodes left
        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                if (adjList.get(neighbor).size() == 1) {
                    leaves.offer(neighbor);
                }
            }
        }

        // The remaining nodes in the leaves queue are the roots of MHTs
        List<Integer> result = new ArrayList<>();
        while (!leaves.isEmpty()) {
            result.add(leaves.poll());
        }
        return result;
    }
}