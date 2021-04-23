import scala.collection.mutable.HashMap

object Playground extends App {
  def pretty(array: AnyRef): String = scala.runtime.ScalaRunTime.stringOf(array)
  val map = new HashMap[String, Int]()
  println(pretty(map))

  println(map += ("Hello" -> 1))
  println(pretty(map))

  println((map.getOrElse("hi", 0)))
  println(map.getOrElse("Hello", 0))

  println(pretty(map ++ List(("hi" -> 2), ("bye" -> 3))))
  println(pretty(map))

  println(pretty(map ++= List(("hi" -> 2), ("bye" -> 3))))
  println(pretty(map))

  println(pretty(map + ("i" -> 23)))
  println(pretty(map))

  println(pretty(map += ("i" -> 42)))
  println(pretty(map))

  println(pretty(map - ("i")))
  println(pretty(map))

  println(pretty(map -= ("i")))
  println(pretty(map))

  println(pretty(map.keySet))
  println(pretty(map.minBy(_._2)))
  println(pretty(map.maxBy(_._2)))

  println(map.isEmpty)
  println(map.size)

  println(pretty(map.partition(_._2 < 2)))
}
