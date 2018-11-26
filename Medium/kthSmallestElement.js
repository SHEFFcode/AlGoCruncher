/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
  let stack = []
  let node = root

  return traverse(node, k, stack)
}

function traverse(node, k, stack) {
  while (node) {
    stack.push(node)
    node = node.left
  }
  node = stack.pop()
  k--
  if (k === 0) {
    return node.val
  }
  node = node.right
  return traverse(node, k, stack)
}
