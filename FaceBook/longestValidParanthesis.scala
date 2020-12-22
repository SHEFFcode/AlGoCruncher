import scala.collection.mutable.ListBuffer

object Solution {
  def longestValidParentheses(s: String): Int = {
    val stack = ListBuffer[Integer]()

    (0 until s.length).foldLeft(0) {
      case (maxLen, i) => {
        if (s(i) == '(') {
          stack += i
          maxLen
        } else {
          stack.remove(stack.length - 1)
          if (stack.isEmpty) {
            stack += (i) // this is the reverse bracket
            maxLen
          } else {
            maxLen max (i - stack(stack.length - 1))
          }
        }
      }
    }
  }
}

/*
G: s: String
O: longestValid: Int
T: O(N)
S: O(N) at most

Notes:
  - Given a string containing just the characters '(' and ')'
  - find the length of the longest valid (well-formed) parentheses substring

Ex:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

( ( )

openCount = 1
wellFormedCount = 1

Ex2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".


) ( ) ( ) )
        i
openCount = 0
wellFormedCount = 2

Ex3:

Input: s = ""
Output: 0

 */
