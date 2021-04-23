import scala.collection.mutable.Queue

object Playground extends App {
  def pretty(array: AnyRef): String = scala.runtime.ScalaRunTime.stringOf(array)
  val q = new Queue[Int]()
  val anotherQ = q ++ (1 :: 2 :: Nil)
  val thirdQ = anotherQ :+ 3
  q ++= (2 :: 3 :: Nil)

  println(pretty(anotherQ))
  println(pretty(thirdQ))
  println(pretty(q))
  println(q.containsSlice(List(2, 3)))
  println(q.dequeue())
  println(pretty(q))
  println(pretty(q.diff(anotherQ)))

  val itemQ = new Queue[Item]()
  itemQ ++= List(Item("Hello", 2), Item("World", 1))

  println(pretty(itemQ))
  println(pretty(itemQ.sortBy(_.age)))
  println(pretty(itemQ.sortWith(_.age < _.age)))
  println(pretty(itemQ))
}

case class Item(val name: String, val age: Int)
