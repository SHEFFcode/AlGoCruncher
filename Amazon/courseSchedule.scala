import scala.collection.immutable.HashMap

object Solution {
  private type Int2List = HashMap[Int, List[Int]]
  private val CAN_FINISH = true
  private val CAN_NOT_FINISH = false
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val graph = prerequisites.foldLeft(HashMap[Int, List[Int]]()) {
      case (g, Array(course, dependency)) => {
        g + (course -> (g.getOrElse(course, List[Int]()) :+ dependency))
      }
    }
    val visited = Array.ofDim[Int](numCourses)

    (0 until numCourses).foldLeft(true) { (canF, course) =>
      if (!dfs(course, visited, graph)) return false else canF
    }
  }

  private def dfs(i: Int, v: Array[Int], g: Int2List): Boolean = {
    if (v(i) == -1) return CAN_NOT_FINISH // currently visiting, cycle!!!
    else if (v(i) == 1) return CAN_FINISH // already visited
    else {
      v(i) = -1 // color node as visited, choose

      for (j <- g.getOrElse(i, List[Int]())) {
        if (!dfs(j, v, g)) return false // explore
      }

      v(i) = 1 // color node as no cycle, un-choose, mark complete
    }
    CAN_FINISH
  }
}

/*
G: numCourses: Int, prerequisites: Array[Array[Int]]
O: canFinish: Boolean
T: O(VE)
S: O(VE)

Notes:
  - Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Ex:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

Ex2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
