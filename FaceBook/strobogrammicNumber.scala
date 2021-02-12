import scala.collection.mutable.ListBuffer

object Solution {
  def findStrobogrammatic(n: Int): List[String] = {
    genNumbers(n, n)
  }

  private def genNumbers(cLevel: Int, ogLen: Int): List[String] = {
    cLevel match {
      case 0 => List("")
      case 1 => List("0", "1", "8")
      case _ => {
        /*
          -2 here to keep odds and evens separate.
          So for odd permutations it's 0, 1, 8 && 1_1, 6_9, 8_8, 9_6
          for evens ONLY 1__1, 6__9, 8__8, 9__6
         */
        val perms = genNumbers(cLevel - 2, ogLen) // similar to fibonacci
        val res = ListBuffer[String]()

        for (perm <- perms) {
          if (cLevel != ogLen) res += s"0${perm}0"
          res += s"1${perm}1" += s"6${perm}9" += s"8${perm}8" += s"9${perm}6"
        }
        res.toList
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
