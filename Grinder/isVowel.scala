object Solution extends App {
  def vowels(str: String) = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')
    str.foldLeft(0) { (acc, char) =>
      if (vowels.contains(char.toLower)) acc + 1
      else acc
    }
  }

  println(vowels("Why?"))
}
