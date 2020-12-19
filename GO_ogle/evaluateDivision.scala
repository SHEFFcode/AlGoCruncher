import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable
object Solution {
  val DIVISION_NOT_POSSIBLE = -1.0
  def calcEquation(
      equations: List[List[String]],
      values: Array[Double],
      queries: List[List[String]]
  ): Array[Double] = {
    val g = HashMap[String, HashMap[String, Double]]()

    equations.zip(values).foreach {
      case (List(dividend, divisor), quot) => {
        g(dividend) = g.getOrElse(dividend, HashMap()) += (divisor -> quot)
        g(divisor) = g.getOrElse(divisor, HashMap()) += (dividend -> 1 / quot)
      }
    }

    queries.zipWithIndex.foldLeft(Array.ofDim[Double](queries.length)) {
      case (answers, (List(dividend, divisor), idx)) => {
        if (!g.contains(dividend) || !g.contains(divisor)) {
          answers(idx) = DIVISION_NOT_POSSIBLE
        } else if (dividend == divisor) {
          answers(idx) = 1.0
        } else {
          val visited = mutable.HashSet[String]()
          answers(idx) = traverse(g, dividend, divisor, 1, visited)
        }
        answers
      }
    }
  }

  private def traverse(
      g: HashMap[String, HashMap[String, Double]],
      cNode: String,
      tNode: String,
      aQ: Double, // accumulated quotient
      v: mutable.HashSet[String] // visited
  ): Double = {
    // Choose
    v += cNode

    // Explore
    val neighbors = g(cNode)

    neighbors.contains(tNode) match {
      case true => return aQ * neighbors(tNode)
      case _ => {
        for (nei <- neighbors) {
          val (nNode, nextAQ) = nei // next node, next aq

          if (!v.contains(nNode)) {
            val result = traverse(g, nNode, tNode, aQ * nextAQ, v)

            if (result != -1.0) return result
          }
        }
      }
    }

    // UnChoose
    v -= cNode
    DIVISION_NOT_POSSIBLE
  }
}

/*
G: equations: List[List[String]], values: Array[Double], queries: List[List[String]]
O: answersToAllQueries: Array[Double]
T: O(N*M) length of equations and length of operations
S: O(N) Length of equations

Notes:
  - If a single answer cannot be determined, return -1.0.
  - The input is always valid.
  - You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
  - Each Ai or Bi is a string that represents a single variable.

Ex:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

{
  ["a","b"]: 2.0
  ["b","c"]: 3.0
}

{
  "a": 2,
  "b": 1,
  "c": .333
}


["a","c"] =>  2 / .333 = 6.00
["b","a"] => 1 / 2 = .50
["a","e"] => -1.0
["a","a"] => 1.0
["x","x"] => -1.0


Ex2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

{
  ["a","b"]: 1.5
  ["b","c"]: 2.5
  ["bc","cd"]: 5.0
}

[{
  "a": 1.5
  "b": 1
  "c": (1 / 2.5)
},{
  "bc": 5
  "cd": 1
}]

["a","c"] => (1.5/(1/2.5))
["c","b"] => (1/2.5)/1
["bc","cd"] => 5 / 1
["cd","bc"] => 1/ 5

Ex3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

{
  ["a","b"]: .5
}

{
  "a": .5,
  "b": 1
}

["a","b"] => .5
["b","a"] => 2
["a","c"] => -1
["x","y"] => -1

""

 */

/*
G: equations: List[List[String]], values: Array[Double], queries: List[List[String]]
O: answersToAllQueries: Array[Double]
T: O(N*M) length of equations and length of operations
S: O(N) Length of equations

Notes:
  - If a single answer cannot be determined, return -1.0.
  - The input is always valid.
  - You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
  - Each Ai or Bi is a string that represents a single variable.

Ex:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

{
  ["a","b"]: 2.0
  ["b","c"]: 3.0
}

{
  "a": 2,
  "b": 1,
  "c": .333
}


["a","c"] =>  2 / .333 = 6.00
["b","a"] => 1 / 2 = .50
["a","e"] => -1.0
["a","a"] => 1.0
["x","x"] => -1.0


Ex2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

{
  ["a","b"]: 1.5
  ["b","c"]: 2.5
  ["bc","cd"]: 5.0
}

[{
  "a": 1.5
  "b": 1
  "c": (1 / 2.5)
},{
  "bc": 5
  "cd": 1
}]

["a","c"] => (1.5/(1/2.5))
["c","b"] => (1/2.5)/1
["bc","cd"] => 5 / 1
["cd","bc"] => 1/ 5

Ex3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

{
  ["a","b"]: .5
}

{
  "a": .5,
  "b": 1
}

["a","b"] => .5
["b","a"] => 2
["a","c"] => -1
["x","y"] => -1

""

 */
