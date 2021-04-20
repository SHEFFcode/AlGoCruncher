object Playground extends App {
  val list = Nil

  println(5 :: list)

  val when = "AM" :: "PM" :: Nil
  println(when)

  val something = when + "GM"

  println(when + "GM")

  println(when ++ "GM")
  println(when :+ "GM")
  println(when.size)
}
