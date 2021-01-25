import scala.collection.mutable.HashMap
object Solution {
  def firstUniqChar(s: String): Int = {
    val map = s.groupBy(identity)
    s.zipWithIndex.foldLeft(-1) {
      case (idx, (c, i)) => if (idx == -1 && map(c).length == 1) i else idx
    }
  }
}

/*
G: s: String
O: idx: Int
T: O(N)
S: O(N)

Notes:
  - Looking for index of first unique char
  - You may assume the string contains only lowercase English letters.

Ex:

 */
