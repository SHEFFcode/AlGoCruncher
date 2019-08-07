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
      List<Integer> edges = new ArrayList<>(Arrays.asList(pair[1]));
      if (!graph.containsKey(pair[1])) {
        graph.put(pair[1], new ArrayList<>()); // let's make sure we have some empty entries.
      }
      graph.merge(pair[0], edges, (oldValue, newValue) -> {
        oldValue.add(pair[1]);
        return oldValue;
      });
    }

    return graph;
  }

  private void visitEdgesAndChildren(int vertex, List<Integer> edges, Map<Integer, List<Integer>> graph,
      Set<Integer> visited, int[] order) {
    for (int edge : edges) {
      if (!visited.contains(edge)) {
        visitEdgesAndChildren(edge, graph.get(edge), graph, visited, order);
      }
    }
    if (!visited.contains(vertex)) {
      visited.add(vertex);
      order[visited.size() - 1] = vertex;
    }
  }
}