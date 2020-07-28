object Solution extends App {
  def anagrams(strA: String, strB: String): Boolean = {
    val cleanA = strA.toLowerCase().replace("!", "")
    val cleanB = strB.toLowerCase().replace("!", "")

    val hashA = cleanA.groupBy(identity)
    val hashB = cleanB.groupBy(identity)

    hashA == hashB // scala implements == as equals for all u java folks
  }

  println(anagrams("hi there", "Bye there!"))
}

/*
anagrams("rail safety", "fairy tales") => True
anagrams("RAIL! SAFETY!", "fairy tales") => True
anagrams("hi there", "Bye there!") => false
 */
