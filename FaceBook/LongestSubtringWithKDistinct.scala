import scala.collection.mutable
object Solution extends App {
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    val letters = mutable.HashMap[Char, Int]()
    var length = 0
    var l = 0 // left pointer

    for (r <- 0 until s.length) {
      val rChar = s(r)
      letters(rChar) = letters.getOrElse(rChar, 0) + 1
      // we may not need the max 0
      while (letters.size > k) {
        val lChar = s(l)
        val decrLChar = letters(lChar) - 1
        (decrLChar > 0) match {
          case true => letters(lChar) = decrLChar
          case _    => letters -= lChar
        }
        l += 1
      }
      length = (length) max (r - l + 1)
    }
    length
  }
}

/*
G: s: String, k: Int
O: longestSubstrKDistinct: Int
T: ???
S: ???

Notes:
  # We might have to guard against -1 (segment of no length)

Ex:
s = "eceba", k = 2

{
  a: 1
  b: 1
}

set.size = 1

longest = l - 1 - r = 3

e c e b a  k = 2
      r
        l


Ex2:
"aa", k = 1

{
  a: 2
}

set.size = 1

longest = l - 1 - r = 1

a a
    r
l
 */
