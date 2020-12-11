object Solution {
  val UNEXPLORED = -1
  val BIPARTITE = true
  val NOT_BIPARTITE = false
  val RED = 0
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val colors = Array.fill(graph.size)(-1)

    (0 until graph.size).forall(i => colors(i) != UNEXPLORED || dfs(i, RED))
  }

  private def dfs(node: Int, color: Int, colors: Array[Int]): Boolean = {
    // the node is explored and is the color it should be
    if (colors(node) == color) return BIPARTITE;
    // the node is explored but is not the color it should be
    if (colors(node) >= 0) return NOT_BIPARTITE;

    colors(node) = color // color the node
    // explore his children
    graph(node).forall(dfs(_, color ^ 1))
  }
}

/*
G: graph: Array[Array[Int]]
O: isBiPartate: Boolean
T: O(N)
S: O(N)

Notes:
  - Graph is bipartite if we can split its set of nodes into two independent subsets A and B such that:
    ^ every edge in the graph has one node in A and another node in B.

Ex:

Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.

 */
