import scala.collection.immutable.HashMap

object Solution {
  private type Int2List = HashMap[Int, List[Int]]
  private val CAN_FINISH = true
  private val CAN_NOT_FINISH = false
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val depGraph = prerequisites.foldLeft(HashMap[Int, List[Int]]()) {
      case (g, Array(course, dependency)) => {
        // Course -> Array(depends*)
        g + (course -> (safeGet(g, course) :+ dependency))
      }
    }

    val visited = Array.ofDim[Int](numCourses)
    (0 until numCourses).foldLeft(true) { (canF, course) =>
      if (!acyclic(course, visited, depGraph)) return false else canF
    }
  }

  private def safeGet(map: HashMap[Int, List[Int]], k: Int): List[Int] = {
    map.getOrElse(k, List[Int]())
  }

  private def acyclic(i: Int, visited: Array[Int], g: Int2List): Boolean = {
    visited(i) match {
      case -1 => CAN_NOT_FINISH // already visited, so cycle
      case 1  => CAN_FINISH // already completed this node, all good
      case _ => {
        visited(i) = -1 // color node as visited

        for (courseReq <- safeGet(g, i)) {
          if (!acyclic(courseReq, visited, g)) return false
        }

        visited(i) = 1 // color node as complete
        CAN_FINISH
      }
    }
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
