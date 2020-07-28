object Solution extends App {
  def capitalize(str: String) = {
    str
      .split(" ")
      .map(word => word.replace(word(0), word(0).toUpper))
      .mkString(" ")
  }

  println(capitalize("hello there"))
}
