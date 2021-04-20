object Payground extends App {
  val hello = "Hello"
  val world = "world"

  println(hello.getClass)
  println(hello * 2)
  println(hello + world)
  println(hello.count(_ == 'l'))
  println(hello.distinct)
  println(hello.drop(2))
  println(hello.dropRight(2))
  println(hello.takeWhile(_.toLower == 'h'))
  println(hello.filter(c => c.toLower == 'l' || c.toLower == 'o'))
  println(hello.groupBy(identity))
  println(hello.head)
  println(hello.tail)
  println(hello.headOption)
  println("".headOption)
  println("".isEmpty())

  println(hello.replace("ll", "pp"))
  println(hello.reverse)

  println(hello.slice(2, 4)) // Hello

  println("    Hello    ".trim)
  println(hello.take(3))
  val hBuffer = hello.toBuffer
  hBuffer += 'k'
  println(hBuffer)
}
