import scala.collection.mutable.HashMap
import scala.collection.mutable.PriorityQueue

object Playground extends App {
  def pretty(array: AnyRef): String = scala.runtime.ScalaRunTime.stringOf(array)
  val pq = new PriorityQueue()(Ordering.Int.reverse)

  val another = pq ++ List(5, 4, 3, 1, 2)
  println(pretty(another.dequeueAll))

  println(pretty(pq += (2)))
  println(pretty(pq))

  println(pretty(pq ++= List(1, 4, 5, 2, 3)))
  println(pq)

}
