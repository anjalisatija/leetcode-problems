class Solution {
    public String crackSafe(int n, int k) {
        int totalEdges = (int) Math.pow(k, n);
        boolean[] visited = new boolean[totalEdges];
        StringBuilder sb = new StringBuilder();
        int mod = totalEdges / k;

        dfs(0, visited, sb, k, mod);

        // Start with (n - 1) zeros + sequence
        for (int i = 0; i < n - 1; i++) sb.append('0');
        return sb.toString();
    }

    private void dfs(int node, boolean[] visited, StringBuilder sb, int k, int mod) {
        for (int i = 0; i < k; i++) {
            int edge = node * k + i;
            if (!visited[edge]) {
                visited[edge] = true;
                dfs(edge % mod, visited, sb, k, mod);
                sb.append(i); // Append in post-order
            }
        }
    }
}