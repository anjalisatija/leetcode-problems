class Solution {
  record Edge(int distance, int node) {
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    // Create an adjacency list to represent the graph.
    Map<Integer, List<Edge>> graph = new HashMap<>();
    for (int[] time : times) {
      Edge edge = new Edge(time[2], time[1]);
      // Create ArrayList if it doesn't exist yet.
      graph.computeIfAbsent(time[0], x -> new ArrayList<Edge>()).add(edge);
    }

    // Initialize distance array.
    int[] distance = new int[n + 1]; // nodes are 1 through n
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[k] = 0; // start node

    // Initialize priority queue.
    PriorityQueue<Edge> pqueue = new PriorityQueue<>(
        // This says to compare edges by weight.
        (edge1, edge2) -> edge1.distance() - edge2.distance());
    pqueue.add(new Edge(0, k));

    // Iterate over the queue until it is empty.
    while (!pqueue.isEmpty()) {
      // Extract the node in the queue with the minimum total distance.
      Edge entry = pqueue.poll();
      int time = entry.distance();
      int node = entry.node();

      // Skip it if there is already a shorter path to this node.
      if (time > distance[node]) {
        continue;
      }

      // Otherwise, try to improve paths to neighbors.
      for (Edge edge : graph.getOrDefault(node, List.of())) {
        // The new time to the neighbor will be the time to the
        // current node plus the distance on the edge.
        int totalTime = time + edge.distance();

        // If the new time is lower, update the distance for the
        // neighbor and add it to the queue.
        if (totalTime < distance[edge.node()]) {
          distance[edge.node()] = totalTime;
          pqueue.add(new Edge(totalTime, edge.node()));
        }
      }
    }

    // Calculate max time.
    int maxTime = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      maxTime = Math.max(maxTime, distance[i]);
    }

    // If any node was unreached, return -1; otherwise, return max time.
    return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
  }
}