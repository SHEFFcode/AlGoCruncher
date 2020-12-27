import scala.collection.immutable.HashMap

object Solution {
  val IS_STROBO = true
  val NOT_STROBO = false
  val CharMap = HashMap[Char, Char]
  def isStrobogrammatic(num: String): Boolean = {
    val map = HashMap(
      ('0' -> '0'),
      ('1' -> '1'),
      ('8' -> '8'),
      ('6' -> '9'),
      ('9' -> '6')
    )

    checkStrobo(num, 0, num.length() - 1, map)
  }

  private def checkStrobo(
      num: String,
      start: Char,
      end: Char,
      map: CharMap
  ): Boolean = {
    if (start > end) return IS_STROBO
    if (start != map.getOrElse(start, ' ')) return NOT_STROBO
    checkStrobo(num, num(start + 1), num(end - 1), map)
  }
}

/*
G: num: String
O: isStrobo: Boolean
T: O(N)
S: O(N)

Notes:
  - A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
  -

Ex:
Input: num = "69"
Output: true

Input: num = "88"
Output: true

Input: num = "962"
Output: false

Input: num = "1"
Output: true

 */
