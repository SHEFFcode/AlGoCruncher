import scala.collection.mutable.LinkedList

object Solution extends App {
  def nFromEnd(list: LinkedList[Int], n: Int): LinkedList[Int] = {
    var slow = list
    var fast = list

    for (_ <- 0 until n) {
      fast.next
    }

    while (fast.next != null) {
      slow = slow.next
      fast = fast.next
    }

    slow
  }
}
