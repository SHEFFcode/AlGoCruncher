import java.{util => ju}
import scala.collection.mutable
object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    if (s.length() == 0) {
      return 0
    }

    val brain = mutable.HashMap[Char, Int]()

    var start = 0
    var end = 0
    var maxLength = 0

    while (end < s.length()) {
      if (!brain.contains(s(end)) || brain(s(end)) < start) {
        brain(s(end)) = end
        end += 1
        if (end == s.length()) {
          maxLength = math.max(maxLength, end - start)
        }
      } else {
        maxLength = math.max(maxLength, end - start)
        start = brain(s(end)) + 1
        brain(s(end)) = end
        end += 1
      }
    }

    maxLength
  }
}

/*
G: s: String
O: lenLongestSubstrNoRepeat: Int
T: O(N), seems like most optimal solution would be O(N)
S: O(1) to O(N) space




Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

{
  a: 3
  b: 7
  c: 5

}

once we get a repeat or end of sentence we count

longest = 3


a b c a b c b b
 *
             #



Ex2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

{
  b: 4
}

b b b b b
 *
         #

Ex3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


{
  p: 0
  w: 5
  k: 3
  e: 4

}

considerationWindowStart = idx
if (set.contains && considerationWindowStart <= set(item))
len: 3

p w w k e w
 *
            #

Ex4:

Input: s = ""
Output: 0

{

}

" "
 *
#


{
  d: 2
  v: 1
}

len: 2

d v d f
 *
    #
 */
