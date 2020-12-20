import collection.mutable.HashSet

object Solution {
  def crackSafe(n: Int, k: Int): String = {
    if (n == 1 && k == 1) return "0"

    val visited = HashSet[String]()
    val seq = new StringBuilder()
    val prefix = "0" * (n - 1)
    dfs(prefix, seq, visited, k)
    seq.append(prefix).toString
  }

  def dfs(pfx: String, seq: StringBuilder, v: HashSet[String], k: Int): Unit = {
    for (i <- 0 until k) {
      val combination = s"$pfx$i"
      if (!v.contains(combination)) {
        v += combination
        dfs(combination.tail, seq, v, k)
        seq.append(i.toString)
      }
    }
  }
}

/*
G: n: Int, k: Int
O: passwordOfMinLen: String
T:
S:

Notes:
   - Password is n digits from 0 to k - 1
   - Return a password of minimum length that will be guaranteed to open the safe

Ex:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.

(0 until 2).foreach(println(_))


Ex2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.

0 1

_ _
 */
