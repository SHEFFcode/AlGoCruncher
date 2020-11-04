import scala.collection.mutable
object Solution extends App {
  def minWindow(s: String, t: String): String = {
    if (s.isEmpty() || t.isEmpty()) return ""

    val charCountNeeded = t.groupBy(identity).mapValues(_.length)
    val charCountInWdw = mutable.HashMap[Char, Int]()
    val sList = s.zipWithIndex.foldLeft(List[(Char, Int)]()) {
      case (acc, (char, idx)) => {
        if (charCountNeeded.contains(char)) acc :+ (char, idx) else acc
      }
    }

    var uniqCharsRemain = charCountNeeded.size
    var ans = Array[Int](-1, 0, 0)
    var r = 0
    var l = 0

    while (r < sList.size) {
      val (rChar, rIdx) = sList(r)
      charCountInWdw(rChar) = charCountInWdw.getOrElse(rChar, 0) + 1

      if (charCountInWdw(rChar) == charCountNeeded(rChar)) {
        uniqCharsRemain -= 1
      }

      while (l <= r && uniqCharsRemain == 0) {
        val (rChar, end) = sList(r)
        val (lChar, start) = sList(l)

        if (ans(0) == -1 || end - start + 1 < ans(0)) {
          ans = Array(end - start + 1, start, end)
        }

        charCountInWdw(lChar) -= 1

        if (charCountInWdw(lChar) < charCountNeeded(lChar)) {
          uniqCharsRemain += 1
        }
        l += 1
      }
      r += 1
    }
    if (ans(0) == -1) "" else s.substring(ans(1), ans(2) + 1)
  }

  println(minWindow("acbbaca", "aba"))
}

// /*
// G: s: String, t: String
// O: minWindowInS: String
// T: O(N)
// S: O(N)

// Notes:
//  * If not window exists return empty string ""
//  * There will be at most 1 min window

// Ex 1:

// s = "ADOBECODEBANC" | t = "ABC" => "BANC"

// {
//   A: 1
//   B: 1
//   C: 1
// }
// charsRemain = 1
// gMinWindow = 4
// {
//   A: [0, 14],
//   B: [3, 13],
//   C: [5, 9, 15],
// }

//  */
