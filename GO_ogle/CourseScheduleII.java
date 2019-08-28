class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] order = new int[numCourses];
    Set<Integer> visited = new HashSet<>();

    Map<Integer, List<Integer>> graph = createGraph(prerequisites, numCourses, order, visited);
    if (findCycle(graph)) {
      return new int[] {};
    }
    for (int vertex = 0; vertex < numCourses; vertex++) {
      if (!visited.contains(vertex)) {
        visitEdgesAndChildren(vertex, graph.get(vertex), graph, visited, order);
      }
    }


    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      if (!visited.contains(entry.getKey())) {
        visitEdgesAndChildren(entry.getKey(), entry.getValue(), graph, visited, order);
      }
    }

    return order;
  }

  private Map<Integer, List<Integer>> createGraph(int[][] prerequisites, int numCourses, int[] order, Set<Integer> visited) {
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

    for (int vertex = 0; vertex < numCourses; vertex++) {
      if (!graph.containsKey(vertex)) {
        visited.add(vertex);
        order[visited.size() - 1] = vertex;
      }
    }

    return graph;
  }

  private void visitEdgesAndChildren(int vertex, List<Integer> edges, Map<Integer, List<Integer>> graph,
      Set<Integer> visited, int[] order) {
    for (int edge : edges) {
      if (!visited.contains(edge)) {
        visited.add(edge);
        visitEdgesAndChildren(edge, graph.get(edge), graph, visited, order);
      }
    }
    if (!visited.contains(vertex)) {
      visited.add(vertex);
      order[visited.size() - 1] = vertex;
    }
  }

  private boolean findCycle(Map<Integer, List<Integer>> graph) {
    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      int currentlyExploring = entry.getKey();
      List<Integer> values = entry.getValue();
      int hasCycle = values.stream().reduce(0, (valid, value) -> {
        if (valid == 1 || graph.get(value).contains(currentlyExploring)) {
          return 1;
        }
        return 0;
      });
      if (hasCycle == 1) {
        return true;
      }
    }
    return false;
  }
}