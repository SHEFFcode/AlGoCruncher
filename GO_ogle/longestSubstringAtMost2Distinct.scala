import scala.collection.mutable
object Solution extends App {
  def lengthOfLongestSubstringTwoDistinct(s: String): Int = {
    val mapOfTwo = mutable.HashMap[Char, Int]()
    var longest = 0
    var l = 0
    var r = 0

    while (r < s.length()) {
      mapOfTwo(s(r)) = r // we will keep the latest index
      r += 1

      if (mapOfTwo.size == 3) {
        val idxToDelete = mapOfTwo.values.min
        mapOfTwo -= s(idxToDelete)
        l = idxToDelete + 1
      }
      longest = longest max (r - l)
    }

    longest
  }
  println(lengthOfLongestSubstringTwoDistinct("cdaba"))
}

/*
G: s: String
O: longest: Int
T: O(N)
S: O(2)

Notes:
  - Find longest substring that contains at most 2 distinct chars
  - All chars are lowercase english letters
  - Can be less than 2 or equal to 2, but not longer

Ex:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

hashMapOf2 {
  b: 1
  a: 1
}

longest = 3

e c e b a
      l
          r

Ex2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

{
  a: 2
  b: 3
}
longest = 5

0 1 2 3 4 5 6
c c a a b b b
    l
              r

Ex: 3
{
  a: 11
}

longest = 0
0 1 2 3 4 5 6 7 8 9 10
a a a a a a a a a a a
l
                      r

 */
