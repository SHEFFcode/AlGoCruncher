import scala.collection.mutable
object Solution {
  val SRC_IDX = 1
  val DEST_IDX = 0
  private type IntToListBuffer =
    mutable.HashMap[Int, mutable.ListBuffer[Int]]
  def findOrder(
      numCourses: Int,
      prerequisites: Array[Array[Int]]
  ): Array[Int] = {
    val topoOrder = Array.ofDim[Int](numCourses)
    val inDegree = Array.ofDim[Int](numCourses)
    var coursesReached = 0
    val depGraph =
      prerequisites.foldLeft(mutable.HashMap[Int, mutable.ListBuffer[Int]]()) {
        case (graph, Array(course, prereq)) => {
          inDegree(course) += 1
          graph(prereq) = safeGet(graph, prereq) :+ course
          graph
        }
      }
    val q = (0 until numCourses).foldLeft(mutable.Queue[Int]()) { (q, course) =>
      if (inDegree(course) == 0) q += course
      q
    }

    while (!q.isEmpty) {
      val course = q.dequeue
      topoOrder(coursesReached) = course
      coursesReached += 1

      for (nei <- safeGet(depGraph, course)) {
        inDegree(nei) -= 1
        if (inDegree(nei) == 0) q += nei
      }
    }

    if (coursesReached == numCourses) topoOrder else Array()
  }

  private def safeGet(g: IntToListBuffer, k: Int): mutable.ListBuffer[Int] = {
    g.getOrElse(k, mutable.ListBuffer[Int]())
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
