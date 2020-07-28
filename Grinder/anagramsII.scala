object Solution extends App {
  def anagrams(strA: String, strB: String): Boolean = {
    val cleanA =
      strA.toLowerCase().replace("!", "").filter(!_.isWhitespace).sorted
    val cleanB =
      strB.toLowerCase().replace("!", "").filter(!_.isWhitespace).sorted

    cleanA == cleanB // scala implements == as equals
  }

  println(anagrams("RAIL! SAFETY!", "fairy tales"))
}

/*
anagrams("rail safety", "fairy tales") => True
anagrams("RAIL! SAFETY!", "fairy tales") => True
anagrams("hi there", "Bye there!") => false
 */
