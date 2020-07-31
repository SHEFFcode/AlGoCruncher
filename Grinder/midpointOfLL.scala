object Solution extends App {
  def findMidpoint(list: LinkedList[Int]) {
    var slow = list.head
    var fast = list.head

    while (fast.next && fast.next.next) {
      slow = slow.next
      fast = fast.next.next
    }

    slow
  }
}
