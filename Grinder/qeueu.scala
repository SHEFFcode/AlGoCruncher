import scala.collection.mutable

object Solution extends App {
  case class Queue() {
    val container = mutable.ArrayBuffer[Int]()
    def enq(num: Int) = {
      container += num
      println(runtime.ScalaRunTime.stringOf(container))
      this
    }

    def deq() = {
      container.remove(0)
      println(runtime.ScalaRunTime.stringOf(container))
      this
    }

    override def toString() = {
      s"Queue(${runtime.ScalaRunTime.stringOf(container).substring(12)}"
    }
  }

  def runExample() = {
    val q = Queue()
    q.enq(2).enq(3).enq(4).deq()
  }

  println((runExample()))
}
