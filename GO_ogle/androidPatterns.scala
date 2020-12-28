import scala.collection.mutable.{HashMap, HashSet}

object Solution {
  private final val skip = HashMap[String, Int](
    ("1,3" -> 2),
    ("3,1" -> 2),
    ("1,7" -> 4),
    ("7,1" -> 4),
    ("3,9" -> 6),
    ("9,3" -> 6),
    ("7,9" -> 8),
    ("9,7" -> 8),
    ("1,9" -> 5),
    ("9,1" -> 5),
    ("3,7" -> 5),
    ("7,3" -> 5),
    ("2,8" -> 5),
    ("8,2" -> 5),
    ("4,6" -> 5),
    ("6,4" -> 5)
  )

  def numberOfPatterns(m: Int, n: Int): Int = {
    (m to n).foldLeft(0) {
      case (ans, i) => {
        // here the corners and inners are identical, so * 4
        // see jamboard notes
        ans + backtrack(1, i - 1, HashSet(1)) * 4 +
          backtrack(2, i - 1, HashSet(2)) * 4 +
          backtrack(5, i - 1, HashSet(5))
      }
    }
  }

  private def backtrack(cNum: Int, remain: Int, seen: HashSet[Int]): Int = {
    if (remain == 0) return 1 // base case

    (1 until 10).foldLeft(0) {
      case (ans, nextNum) => {
        if (isValid(nextNum, cNum, seen)) {
          // choose
          seen += nextNum
          // explore
          val nAns = ans + backtrack(nextNum, remain - 1, seen)
          // unchoose
          seen -= nextNum
          nAns
        } else ans
      }
    }
  }

  private def isValid(nextNum: Int, cNum: Int, seen: HashSet[Int]): Boolean = {
    val key = s"$cNum,$nextNum"
    !seen.contains(nextNum) && (!skip.contains(key) || seen.contains(skip(key)))
  }
}

/*
G: m: Int, n: Int
O: numberOfPatterns: Int
T: O(n!) n is max pattern length
S: O(n) s maximum pattern length

Notes:

Ex:

 */
