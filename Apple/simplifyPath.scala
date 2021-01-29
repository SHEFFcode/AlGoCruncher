import scala.collection.mutable.ListBuffer
object Solution {
  def simplifyPath(path: String): String = {
    var stack = ListBuffer[String]()
    val components = path.split("/")
    for (dir <- components) {
      dir match {
        case ".."     => if (!stack.isEmpty) stack.remove(stack.size - 1)
        case "." | "" => // ignore
        case _        => stack += dir
      }
    }
    "/" + stack.mkString("/")
  }
}

/*
G:
O:
T:
S:

Notes:
  -

Ex:
Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
 */
