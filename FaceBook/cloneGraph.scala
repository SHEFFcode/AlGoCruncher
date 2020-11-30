import scala.collection.mutable.HashMap
import scala.collection.mutable.Queue

/**
  * Definition for a Node.
  * class Node(var _value: Int) {
  *   var value: Int = _value
  *   var neighbors: List[Node] = List()
  * }
  */

object Solution {
  def cloneGraph(graph: Node): Node = {
    if (graph == null) return graph

    val visited = HashMap[Node, Node]() // node to node^ (node prime)
    val q = Queue[Node](graph) // contains only the original nodes

    visited(graph) = new Node(graph.value)

    while (!q.isEmpty) {
      val ogNode = q.dequeue // ogNode as in the original node :)
      for (ogNeighbor <- ogNode.neighbors) {
        if (!visited.contains(ogNeighbor)) {
          visited(ogNeighbor) = new Node(ogNeighbor.value)
          q += ogNeighbor
        }
        // basically we want to add a copy of original neighbor to a copy of original node
        // to do this, we do the work above
        val copyNodeNeighbors = visited(ogNode).neighbors
        visited(ogNode).neighbors = copyNodeNeighbors :+ visited(ogNeighbor)
      }
    }

    // once we have traversed the whole graph, we will return the copy of original node
    visited(graph)
  }
}

/*
G: graph: Node
O: deepClone: Node
T: O(N)
S: O(N)

Notes:
  - The node given will be of a connected undirected graph
  - You return a copy of that first given node as a reference for the test case

Ex:



 */
