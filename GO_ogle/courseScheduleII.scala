import scala.collection.mutable
object Solution {
  val SRC_IDX = 1
  val DEST_IDX = 0
  def findOrder(
      numCourses: Int,
      prerequisites: Array[Array[Int]]
  ): Array[Int] = {
    val adjList = mutable.HashMap[Integer, mutable.ListBuffer[Int]]()
    val inDegree = Array.ofDim[Int](numCourses)
    val topologicalOrder = Array.ofDim[Int](numCourses)

    for (i <- 0 until prerequisites.length) {
      val src = prerequisites(i)(SRC_IDX)
      val dest = prerequisites(i)(DEST_IDX)
      adjList(src) = adjList.getOrElse(src, mutable.ListBuffer[Int]()) :+ dest

      // record in degree
      inDegree(dest) += 1
    }

    val q = (0 until numCourses).foldLeft(mutable.Queue[Int]()) { (q, i) =>
      if (inDegree(i) == 0) q += i
      q
    }

    var i = 0
    while (!q.isEmpty) {
      val node = q.dequeue
      topologicalOrder(i) = node
      i += 1

      for (nei <- adjList.getOrElse(node, mutable.ListBuffer[Int]())) {
        inDegree(nei) -= 1
        if (inDegree(nei) == 0) q += nei
      }
    }

    println(scala.runtime.ScalaRunTime.stringOf(adjList))
    println(scala.runtime.ScalaRunTime.stringOf(inDegree))
    println(scala.runtime.ScalaRunTime.stringOf(topologicalOrder))

    if (i == numCourses) topologicalOrder else Array[Int]()
  }
}

/*
G: numCourses: Int, prerequisites: Array[Array[Int]]
O: topoSort: Array[Int]
T: O(N)
S:O(N)

Notes:
  - this will be a topological sort problem
  - If there are many valid answers, return any of them.
  - If it is impossible to finish all courses, return an empty array.

Ex:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

 */

/*
G: numCourses: Int, prerequisites: Array[Array[Int]]
O: topoSort: Array[Int]
T: O(N)
S:O(N)

Notes:
  - this will be a topological sort problem
  - If there are many valid answers, return any of them.
  - If it is impossible to finish all courses, return an empty array.

Ex:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

 */
