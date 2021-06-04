/**
  * Definition for a binary tree node.
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  *   var value: Int = _value
  *   var left: TreeNode = _left
  *   var right: TreeNode = _right
  * }
  */
object Solution {
  def flatten(root: TreeNode): Unit = {
    if (root == null) return // easy part
    var cNode = root
    while (cNode != null) {
      if (cNode.left != null) {
        // if we have a left child
        // find it's rightmost node (rightMost child of cNode)
        var rightMostToLeftOfNode = cNode.left
        while (rightMostToLeftOfNode.right != null) {
          rightMostToLeftOfNode = rightMostToLeftOfNode.right
        }

        // rewrite the connections

        // regardless of existence of left node
        // rewire the connections

        // we know the right child here is null
        // per above while loop, so safe to rewire
        // rightMostToLeftOfNode's left child stays as is
        rightMostToLeftOfNode.right = cNode.right
        cNode.right = cNode.left // flatten this level
        cNode.left = null // garbage collect the rewired nodes above
      }
      // move on to the right side of the tree
      cNode = cNode.right
    }
  }
}

/*
G: root: TreeNode
O: flattenedRoot: TreeNode
T: Any
S: Any

Notes:
  - Just need to be a single list heading right

Ex:
    1
   / \
  2   5
 / \   \
3   4   6

=>

    1
     \
      2
     / \
    3   4
         \
          5
           \6

=>

     1
      \
       2
        \
         3
          4
           5
            6 d
=>

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 */
