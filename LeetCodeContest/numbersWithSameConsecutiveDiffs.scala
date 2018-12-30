object Solution {
    def numsSameConsecDiff(N: Int, K: Int): Array[Int] = {
      val resultList = new StringBuilder
        if (N == 1) resultList ++= s"${0},"
      def traverse(str: String, K: Int, N: Int, curPos: Int): Unit = {
        if (str.length != curPos - 1) return
        if (str.length == N) {
          resultList ++= (str + ",")
          return
        }
        if (str.charAt(curPos - 1 - 1) - '0' + K < 10) 
          traverse(str + s"${str.charAt(curPos - 1 - 1) - '0' + K}", K, N, curPos + 1)
        if (str.charAt(curPos - 1 - 1) - '0' - K >= 0) 
          traverse(str + s"${str.charAt(curPos - 1 - 1) - '0' - K}", K, N, curPos + 1)
      }

      (1 to 9).foreach(digit => traverse(s"$digit", K, N, 2))

      resultList.toString().split(",").map(_.toInt).toList.distinct.toArray
    }
  }