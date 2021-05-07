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
    val gClone = new Node(graph.value)

    val clones =
      HashMap[Node, Node](graph -> gClone) // node to node^ (node prime)
    val q = Queue[Node](graph) // contains only the original nodes

    while (!q.isEmpty) {
      val ogNode = q.dequeue // ogNode as in the original node :)
      for (ogNeighbor <- ogNode.neighbors) {
        if (!clones.contains(ogNeighbor)) {
          clones(ogNeighbor) = new Node(ogNeighbor.value)
          q += ogNeighbor
        }
        // basically we want to add a copy of neighbor node to a copy of node's neighbors
        // to do this, we do the work above
        clones(ogNode).neighbors :+= clones(ogNeighbor)
      }
    }

    // once we have traversed the whole graph, we will return the copy of original node
    clones(graph)
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
