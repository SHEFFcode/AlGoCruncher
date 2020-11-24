import scala.collection.mutable.ListBuffer
object Solution extends App {
  def backspaceCompare(S: String, T: String): Boolean = {
    val s = processString(S)
    val t = processString(T)

    s == t
  }

  private def processString(string: String): String = {
    val lb = new ListBuffer[Char]()
    for (c <- string) {
      if (c != '#') {
        lb += c
      } else if (lb.size > 0) {
        lb.remove(lb.size - 1)
      }
    }
    lb.toString
  }

  println(backspaceCompare("ab#c", "ad#c"))
}

/*
G: S: String, T: String
O: areEqual: Boolean
T: O(N)
S: ???

Notes:
  -

Ex:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

"ab#c"   "ad#c"

(ac)     (ac)

 */
