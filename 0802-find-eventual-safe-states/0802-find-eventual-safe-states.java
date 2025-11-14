class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build reverse graph and outdegree
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                adj.get(v).add(u);   // reverse edge
            }
            outdegree[u] = graph[u].length;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int prev : adj.get(node)) {
                outdegree[prev]--;
                if (outdegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}