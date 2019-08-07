class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = createGraph(prerequisites);
    int[] order = new int[numCourses];
    Set<Integer> visited = new HashSet<>();
    for (Map.Entry entry : graph.getEntries()) {
      if (!visited.contains(entry.getKey())) {
        visitEdgesAndChildren(entry.getKey(), entry.getValue(), visited, order, graph);
      }
    }

    return order;
  }

  private Map<Integer, List<Integer>> createGraph(int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

    for (int[] pair : prerequisites) {
      List<Integer> edges = graph.getOrDefault(pair[0], new ArrayList<Integer>());
      edges.add(paris[1]);
      graph.put(edges);
    }

    return graph;
  }

  private void visitEdgesAndChildren(int vertex, List<Integer> edges, Map<Integer, List<Intger>> graph,
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