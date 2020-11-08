object Solution extends App {
  def isOneEditDistance(s: String, t: String): Boolean = {
    if (s.length > t.length) return isOneEditDistance(t, s)

    val shortLen = s.length
    val longLen = t.length

    if (longLen - shortLen > 1) {
      return false
    }

    for (i <- 0 until shortLen) {
      if (s(i) != t(i)) {
        shortLen == longLen match {
          case true => return s.substring(i + 1) == t.substring(i + 1)
          case _    => return s.substring(i) == t.substring(i + 1)
        }
      }
    }

    shortLen + 1 == longLen
  }
}

/*
G: s: String, t: String
O: areOneEditDistanceApart: Boolean
T: ???
S: ???

Notes:
  - One edit distance is when u can:
    # Insert exactly one char into s to get t
    # Delete exactly one char from s to get t
    # Replace exactly one diff char in s to get t
  - Observations:
    # If the lengths differ by more than 1 char, return false
    # Position of the char in the string matters, so u can't just hash it
    # Keep a counter of number of changes, such that if chars don't match, we increment
    # It would be nice to know which string is the shorter one, to make the loop easier
    # If two strings are already the same, return false (if nChanges != 1) return false
    # If we run out of smaller string, and nChanges is still 0, return true
    # If changes ever become more than 1, return false


Ex1:
s = "ab", t = "acb" => true


var nChanges = 1

a b
    ^
a c b
      #

Ex2:
s = "", t = "" => false this is almost by definition

Ex3:
s = "ab", t = "abc" => true

nChanges = 0

a b
  ^
a b c
  #

Ex4:
s = "ab", t = "adc" => false

nChanges = 1

a b
  ^
a d c
    #

Ex5:
s = "abcde", t = "abde" => true

nChanges = 1

a b d e
      ^
a b c d e
        #
 */
