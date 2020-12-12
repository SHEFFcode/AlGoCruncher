import scala.collection.mutable.HashMap

/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def verticalOrder(root: TreeNode): List[List[Int]] = {
    traverse(root, 0, 0).toList
      .sortBy(_._1) // sort by width, left most numbers go to the top
      .map(_._2.sortBy(_._1)) // get just the depth, node tuple, sort by depth
      .map(_.map(_._2)) // take the list of tuples and take the node value
  }

  def traverse(
      cNode: TreeNode,
      width: Int,
      depth: Int,
      brain: HashMap[Int, List[(Int, Int)]] = HashMap()
  ): HashMap[Int, List[(Int, Int)]] = {
    if (cNode != null) {
      brain(width) =
        brain.getOrElse(width, List[(Int, Int)]()) :+ (depth, cNode.value)
      traverse(cNode.left, width - 1, depth + 1, brain)
      traverse(cNode.right, width + 1, depth + 1, brain)
    }
    brain
  }
}

/*
G: root: TreeNode
O: verticalOrderTraversal: List[List[Int]]
T: O(N)
S: O(N)

Notes:
  - If two nodes are in the same row and column, they should be ordered right to left.

Ex:

Input: [3,9,20,null,null,15,7]

{
   0: [3, 15],
  -1: [9],
   1: [20],
   2: [7]
}

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]

Ex2:
Input: [3,9,8,4,0,1,7]

{
  -2: [4],
  -1: [9]
   0: [3,0, 1],
   1: [8],
   2: 7
}

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]

 */
