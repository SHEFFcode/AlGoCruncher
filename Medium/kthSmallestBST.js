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
var kthSmallest = function (root, k) {
  let contaier = [0, null];

  return _traverse(root, contaier, k)[1];
};

function _traverse(cNode, container, k) {
  if (!cNode.right && !cNode.left || container[1]) {
    container[0]++;
    if (container[0] === k) {
      container[1] = cNode.val;
    }
    return container;
  }

  let result;
  if (cNode.left)
    container = _traverse(cNode.left, container, k);
  container[0]++;
  if (container[0] === k) {
    container[1] = cNode.val;
    return container;

  }
  if (cNode.right)
    container = _traverse(cNode.right, container, k);

  return container;
}