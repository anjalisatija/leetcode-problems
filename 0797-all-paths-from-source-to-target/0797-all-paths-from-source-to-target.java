class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); //start from node 0
        dfs(graph, 0, path, paths);
        return paths;
    }
    
    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        if(node == graph.length-1) { //target node reached
            paths.add(new ArrayList<>(path));
            return;
        }

        for(int neighbor: graph[node]) {
            path.add(neighbor);
            dfs(graph, neighbor, path, paths);
            path.remove(path.size()-1); //backtrack
        }
    }
}