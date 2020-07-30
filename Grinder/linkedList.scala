case class LinkedList[T]() {
  var head: Node[T] = null
}

class Node[T](var data: T, var next: Node[T]) {
  def getData: T = this.data

  def getNext: Node[T] = this.next

  def printList(): Unit = {
    print(data)

    if (next != null) {
      print(",")
      next.printList()
    }
  }
}

object Solution extends App {
  def listMe() = {
    val anotherNode = new Node[Int](2, null)
    val headNode = new Node[Int](1, anotherNode)
    headNode.printList()
  }

  listMe()
}
