object Solution extends App {
  def mostCommonChars(str: String): Char = {
    val mapOfCharToOccurance = str.toSeq.groupBy(identity)
    val mostCommonCharToOccurance = mapOfCharToOccurance.maxBy(_._2.length)
    mostCommonCharToOccurance._1
  }

  println(mostCommonChars("abcdc"))
}