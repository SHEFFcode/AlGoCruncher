import scala.collection.immutable.HashMap
import scala.collection.mutable.ListBuffer

object Solution {
  private final type CharMap = HashMap[Char, Char]
  private final type StrList = List[String]
  def findStrobogrammatic(n: Int): List[String] = {
    val map = HashMap(
      ('0' -> '0'),
      ('1' -> '1'),
      ('8' -> '8'),
      ('6' -> '9'),
      ('9' -> '6')
    )

    val res = ListBuffer[String]()
    val strobos = construct(Array.ofDim[Char](n), 0, n - 1, map, res)
    res.toList
  }

  private def construct(
      chars: Array[Char],
      start: Int,
      end: Int,
      map: CharMap,
      acc: ListBuffer[String]
  ): Unit = {
    if (start > end) {
      if (chars.length == 1 || chars(0) != '0') {
        acc += chars.mkString
      }
      return ()
    }

    for ((k, v) <- map) {
      if (start != end || k == v) {
        chars(start) = k
        chars(end) = v
        construct(chars, start + 1, end - 1, map, acc)
      }
    }
  }

}

/*
G: n: Int
O: allStrobogramicNumbers: Lis[String]
T:
S:

Notes:
  - A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Ex:
Input:  n = 2
Output: ["11","69","88","96"]

So all the numbers are:
  - 1, 6, 8, 9 => n = 1
  - 11, 69, 88, 96 => n = 2
  - 111, 888 => n = 3
  - 1111, 6969

 */
