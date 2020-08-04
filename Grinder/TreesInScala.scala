import scala.collection.mutable.ArrayBuffer

case class Tree(var root: Node = null) {}

case class Node(val data: Int, var children: ArrayBuffer[Node]) {
  def add(data: Int) = {
    val nodeToAdd = new Node(data, new ArrayBuffer[Node]())
    children += nodeToAdd
  }

  def remove(data: Int) = {
    children = children.filter(_.data == data)
  }
}
