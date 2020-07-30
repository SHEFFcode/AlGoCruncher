case class LinkedList[T]() {
  var head: Node[T] = null

  def push(data: T) = {
    head match {
      case null => head = new Node(data, null)
      case _ => {
        var last = head

        while (last.next != null) {
          last = last.next
        }

        last.next = new Node(data, null)
      }
    }
  }

  def prepend(data: T) = {
    val tempHeadNode: Node[T] = new Node[T](data, head)
    head = tempHeadNode
  }
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
    // headNode.printList()

    val ll = new LinkedList[Int]()

    ll.push(3)
    ll.push(4)
    ll.prepend(2)
    ll.prepend(1)
    ll.head.printList()
  }

  listMe()
}
