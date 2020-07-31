object Solution extends App {
  def findMidpoint(list: LinkedList[Int]) {
    var slow = list.head
    var fast = list.head

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next
      fast = fast.next.next
    }

    slow
  }
}
