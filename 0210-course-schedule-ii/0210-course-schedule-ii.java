class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree = new int[n];  // Keeps track of how many prerequisites each course has
        Map<Integer, List<Integer>> map = new HashMap<>();  // Adjacency list representing course dependencies
        boolean[] visited = new boolean[n];  // Marks whether a course has been visited
        List<Integer> result = new ArrayList<>();  // Stores the valid course order
        int[] answer = new int[n];  // Final result array

        // Build the graph and fill indegree array
        for (int[] pre : prerequisites) {
            int a = pre[0];  // Course a
            int b = pre[1];  // Prerequisite b for course a

            indegree[a]++;  // Course a has one more prerequisite

            // Add edge b -> a in the graph
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        // Start DFS from courses with no prerequisites
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0 && !visited[i]) {
                dfs(i, visited, map, indegree, result);
            }
        }

        // If any course hasn't been visited, a cycle exists → return empty array
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return new int[] {};
            }
        }

        // Copy result list into answer array
        for (int i = 0; i < n; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // DFS to process each course and reduce indegree of its neighbors
    private void dfs(int course, boolean[] visited, Map<Integer, List<Integer>> map,
                     int[] indegree, List<Integer> result) {
        visited[course] = true;       // Mark course as visited
        result.add(course);           // Add course to the result order

        List<Integer> courses = map.get(course);  // Get courses dependent on current course

        if (courses != null) {
            for (int c : courses) {
                indegree[c]--;  // One prerequisite is now satisfied
                if (indegree[c] == 0 && !visited[c]) {
                    dfs(c, visited, map, indegree, result);  // Recurse if course is now free to take
                }
            }
        }
    }
}