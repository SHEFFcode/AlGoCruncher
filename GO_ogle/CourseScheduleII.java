class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = createGraph(prerequisites);
    int[] order = new int[numCourses];
    Set<Integer> visited = new HashSet<>();
    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      if (!visited.contains(entry.getKey())) {
        visitEdgesAndChildren(entry.getKey(), entry.getValue(), graph, visited, order);
      }
    }

    return order;
  }

  private Map<Integer, List<Integer>> createGraph(int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int[] pair : prerequisites) {
      List<Integer> edges = graph.getOrDefault(pair[0], new ArrayList<>());
      edges.add(pair[1]);
      graph.merge(pair[0], edges, (oldValue, newValue) -> {
        oldValue.add(pair[0]);
        return oldValue;
      });
    }

    return graph;
  }

  private void visitEdgesAndChildren(int vertex, List<Integer> edges, Map<Integer, List<Integer>> graph,
      Set<Integer> visited, int[] order) {
    if (edges.isEmpty()) {
      visited.add(vertex);
      order[visited.size()] = vertex;
    } else {
      for (int edge : edges) {
        visitEdgesAndChildren(edge, graph.get(edge), graph, visited, order);
      }
    }
  }
}