import scala.collection.mutable.ArrayBuffer

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def widthOfBinaryTree(root: TreeNode): Int = {
    val leftArr =
      ArrayBuffer[TreeNode](root) // this is apply will make an array
    val rightArr = new ArrayBuffer[TreeNode]()

    traverse(leftArr, rightArr, 0)
  }

  def traverse(
      mainArr: ArrayBuffer[TreeNode],
      sideArr: ArrayBuffer[TreeNode],
      globalMax: Int
  ): Int = {
    if (mainArr.length == 0) return globalMax
    mainArr.foreach {
      case cNode: TreeNode => sideArr += cNode.left; sideArr += cNode.right;
      case _               =>
    }

    val sA = sideArr.reverse.dropWhile(_ == null)
    mainArr.clear
    math.max(
      globalMax,
      traverse(sA, mainArr, math.max(globalMax, sA.length))
    )
  }
}

// My first thought here is to do a BFS on a tree, and count how wide that becomes

/*
Use two stacks, while either of the stacks is not empty:
while (activeStack.last == -1) activeStack.pop()

            1
         /   \
        3     2
       / \     \
      5   3     9


      [] []
      maxLength = math.max(prevMax, activeStack.length)

 */
