import scala.collection.mutable

object Solution extends App {
  case class Queue() {
    protected val container = mutable.ArrayBuffer[Int]()
    def enq(num: Int) = {
      container += num
      println(runtime.ScalaRunTime.stringOf(container))
      this
    }

    def deq() = {
      container.remove(container.size - 1)
      println(runtime.ScalaRunTime.stringOf(container))
      this
    }

    def peek() = {
      println(container(container.size - 1))
      this
    }

    override def toString() = {
      s"Queue(${runtime.ScalaRunTime.stringOf(container).substring(12)}"
    }
  }

  def runExample(): Queue = {
    val q = Queue()
    q.enq(2).enq(3).enq(4).peek().deq()
  }

  println((runExample()))
}
