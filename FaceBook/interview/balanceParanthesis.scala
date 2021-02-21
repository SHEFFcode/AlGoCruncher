import scala.collection.mutable.ListBuffer
object Solution extends App {
  def balanceParenthesis(str: String): String = {
    var lCount = 0
    val stack = ListBuffer[Char]()

    for (c <- str) {
      c match {
        case c @ '(' => {
          lCount += 1
          stack += c
        }
        case c @ ')' => {
          if (lCount > 0) {
            lCount -= 1
            stack += c
          }
        }
        case c @ _ => stack += c
      }
    }

    var i = stack.size - 1
    while (lCount > 0) {
      if (stack(i) == '(') {
        stack.remove(i)
      }
      lCount -= 1
      i -= 1
    }

    stack.mkString
  }

  println(balanceParenthesis("(a)b(c)d(e)f)(g)"))
  println(balanceParenthesis("(a(c()b)"))
  println(balanceParenthesis("a(b))"))
  println(balanceParenthesis(")("))
  println(balanceParenthesis(")a(b)c()("))
  println(balanceParenthesis("ab(a(c)fg)9)"))
}

/*
G: str: String
O: balancedParensString: String
T: O(N)
S: O(1)

Notes:
  - Given a string str consisting of parentheses (, ) and alphanumeric characters.
  - Remove minimum number of paranthesis to make the string valid and return any valid result.
  - In a valid string for every opening/closing parentheses there is a matching closing/opening one.

Ex:

 */
