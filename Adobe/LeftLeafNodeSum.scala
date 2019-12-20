/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sumOfLeftLeaves(root: TreeNode): Int = {
        leafAdder(root, false) // root is not a left leaf node
    }

    private def leafAdder(cNode: TreeNode, isLeftNode: Boolean): Int = {
        if (cNode == null) {
            0 // this is the the very first node, or one of the right nodes, which won't be counted
        } else {
            if (isLeftNode && cNode.left == null && cNode.right == null) {
                cNode.value
            }
            else {
                leafAdder(cNode.left, true) + leafAdder(cNode.right, false)
            }
        }
    }
}

/*
    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.



    3
  9  20


@Child
    if (cNdoe.left == null) {
        return cNode.value
    }

@Parent
    val sumOfLeftsOnLeft = countLeft(cNode.left)
    val sumOfLeftsOnRight = countLeft(cNode.right)

    return sumOfLeftsOnLeft + sumOfLeftsOnRight

*/