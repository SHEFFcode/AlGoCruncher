object Solution {
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    logs.sorted(logComparator)
  }

  private def logComparator(s1: String, s2: String): Int = {
    val Array(id1, rest1) = s1.split(" ", 2)
    val Array(id2, rest2) = s2.split(" ", 2)

    val isDigit1 = rest1(0).isDigit
    val isDigit2 = rest2(0).isDigit

    if (!isDigit1 && !isDigit2) {
      val comp = rest1.compareTo(rest2) // standard string comp
      if (comp == 0) id1.compareTo(id2) else comp // tie breakers
    } else if (!isDigit1) -1 // pull first (letter) string forward
    else if (!isDigit2) 1 // pull first (digit) string back
    else 0 // keep in place (both digit)
  }
}

/*
G: logs: Array[String]
O: orderedLogs: Array[String]
T: O(N)
S: O(N)

Notes:
  - Each log is a space delimited string of words.
  - For each log, the first word in each log is an alphanumeric identifier, then:
    ^ Each word after the identifier will consist only of lowercase letters (letter-logs)
    ^ Each word after the identifier will consist only of digits (digit-logs)
  - It is guaranteed that each log has at least one word after its identifier.
  - Reorder the logs so that all of the letter-logs come before any digit-log.
    ^ The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
    ^ The digit-logs should be put in their original order.
  - Return the final order of the logs.

Ex:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
