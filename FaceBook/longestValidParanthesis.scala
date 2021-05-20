import scala.collection.mutable.Stack

object Solution {
  def longestValidParentheses(s: String): Int = {
    val stack = Stack[Integer](-1)

    (0 until s.length).foldLeft(0) {
      case (maxLen, i) => {
        if (s(i) == '(') {
          stack.push(i)
          maxLen
        } else {
          stack.pop()
          if (stack.isEmpty) {
            stack.push(i) // this is the reverse bracket
            maxLen
          } else {
            maxLen max (i - stack.head)
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
