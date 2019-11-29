object Solution {
    def minDistance(word1: String, word2: String): Int = {
      val word1Length = word1.length
      val word2Length = word2.length

      // If one of the strings is empty
      if (word1Length * word2Length == 0) {
        return word1Length + word2Length
      }

      val matrix = Array.tabulate[Int](word1Length + 2, word2Length + 2) { (index1, index2) =>
        if (index1 == 0) index2
        else if (index2 == 0) index1
        else 0
      }

      for {
        i <- (1 until (word1Length + 1))
        j <- (1 until (word2Length + 1))
      } yield {
        val left = matrix(i - 1)(j) + 1
        val right = matrix(i)(j - 1) + 1
        var diagonal = matrix(i - 1)(j - 1)

        if (word1(i - 1) != word2(j - 1)) {
          diagonal = diagonal + 1
        }

        matrix(i)(j) = Math.min(left, Math.min(right, diagonal))
      }

      matrix(word1Length + 1)(word2Length + 1)
    }
}