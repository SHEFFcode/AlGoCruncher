import scala.collection.mutable.LinkedList

object Solution extends App {
  def isCircular(list: LinkedList[Int]): Boolean = {
    var slow = list
    var fast = list

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next
      fast = fast.next.next

      if (slow == fast) {
        return true
      }
    }

    false
  }
}
