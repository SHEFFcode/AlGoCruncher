object Solution extends App {
  def findReplaceString(
      S: String,
      indexes: Array[Int],
      sources: Array[String],
      targets: Array[String]
  ): String = {
    var sWithReplacements = new StringBuilder()
    var cIndex = 0
    val iXY = (indexes, sources, targets).zipped.toArray.sortWith(_._1 < _._1)

    for (idx <- 0 until indexes.length) {
      val (i, x, y) = iXY(idx)

      val unmodifiedChars = S.substring(cIndex, i)
      sWithReplacements ++= unmodifiedChars.toString()
      cIndex = i

      val xLen = x.length()
      val canReplace = S.substring(i, xLen + i) == x
      if (canReplace) {
        sWithReplacements ++= y.toString()
        cIndex += xLen
      }
    }

    if (cIndex != S.length) {
      sWithReplacements ++= (S.substring(cIndex, S.length()))
    }

    sWithReplacements.toString()
  }

  println(
    findReplaceString(
      "vmokgggqzp",
      Array(3, 5, 1),
      Array("kg", "ggq", "mo"),
      Array("s", "so", "bfr")
    )
  )
}

/*
G: S: String, idexes: Array[Int], sources: Array[String], targets: Array[String]
O: sWithReplacements: String
T: O(N)
S: O(N)

Notes:
  - We will perform replace operations (target is not nec same size as source)
  - Each operation has 3 params:
    ^ Starting index i
    ^ Source word x
    ^ Target word y
  - If original string starts with chars in x at position i, we do the replace, otherwise don't
  - Lowercase english letters


Ex:

 */
