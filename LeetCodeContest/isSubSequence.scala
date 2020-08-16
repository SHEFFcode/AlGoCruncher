import scala.annotation.tailrec
object Solution extends App {
  def isSubsequence(s: String, t: String): Boolean = {
    val sLength = s.length
    var tLength = t.length

    @tailrec
    def explore(sIndex: Int, tIndex: Int): Boolean = {
      if (sIndex == sLength) {
        return true // we found all the els of s in t
      }

      if (tIndex == tLength) {
        return false // we ran out of t, but not of s
      }

      if (s(sIndex) == t(tIndex)) {
        // if we find a letter, let's move both pointers forward
        return explore(sIndex + 1, tIndex + 1)
      } else {
        // if we don't find a letter, let's just move the t pointer forward
        return explore(sIndex, tIndex + 1)
      }
    }

    explore(0, 0)
  }
}

/**
  * Input: s = "abc", t = "ahbgdc"
  * Output: true
  *
  * a b c  | a h b g d c
  *     i          j
  */

/**
  * Input: s = "abc", t = "ahbgdc"
  * Output: true
  *
  * a b c  | a h b g d c
  *     i          j
  */
