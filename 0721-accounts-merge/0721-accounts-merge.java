class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // build the graph using adjacency list
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            // link all emails to their  first email (assuming undirected graph)
            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                adjMap.putIfAbsent(firstEmail, new ArrayList<>());
                adjMap.putIfAbsent(email, new ArrayList<>());

                // bidirectional edge
                adjMap.get(firstEmail).add(email);
                adjMap.get(email).add(firstEmail);

                // track the name
                emailToName.put(email, name);
            }
        }

        // applying  DFS to find all connected components (i.e., merged accounts)
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : adjMap.keySet()) {

            if (!visited.contains(email)) {

                List<String> component = new ArrayList<>();
                dfs(email, adjMap, visited, component);

                // sort emails and add name at the beginning
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                result.add(component);
            }
        }

        return result;
    }

    private void dfs(String email, Map<String, List<String>> adjMap, Set<String> visited, List<String> component) {

        visited.add(email);
        component.add(email);

        for (String neighbor : adjMap.get(email)) {
            
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjMap, visited, component);
            }
        }
    }
}