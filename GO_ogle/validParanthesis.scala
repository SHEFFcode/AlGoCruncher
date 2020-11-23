import scala.collection.immutable.HashMap
import scala.collection.mutable.Stack
object Solution extends App {
  def isValid(s: String): Boolean = {
    val compliments = HashMap(('(' -> ')'), ('[' -> ']'), ('{' -> '}'))
    val stack = Stack[Int]()

    for (c <- s) {
      compliments.contains(c) match {
        case true                    => stack.push(compliments(c))
        case false if stack.size > 0 => if (c != stack.pop()) return false
        case _                       => return false
      }
    }

    stack.size == 0
  }

  println(isValid("]"))
}

/*
G: s: String
O: paransValid: Boolean
T: O(N)
S: O(N)

Notes:
  - Output is valid if:
    ^ Open brackets must be closed by the same type of bracket
    ^ Open brackets must be closed in the correct order.
  - Characters can be:
    ^ '(', ')', '{', '}', '[', ']'

Ex:
Input: s = "()"
Output: true

{
  '(': ')'
}

stack: [  ]

( )
  i

Ex2:
Input: s = "()[]{}"
Output: true

stack: []

( ) [ ] { }
          i

Ex3:
Input: s = "(]"
Output: false

stack: [)]

( ]
  i

Ex3:
Input: s = "([)]"
Output: false

stack: ), ]

( [ ) ]
    i

Ex4:
Input: s = "{[]}"
Output: true

stack:

{ [ ] }
      i
 */
