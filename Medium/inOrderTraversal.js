/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */

/*
In Order is left, root, right
Pre Order is root, left, right
Post Order is left, right, root

Just refers to the root, in order means in the middle, pre order means before, post order mean after
*/

var inorderTraversal = function (root) {
  if (!root) {
    return [];
  }

  let stack = [];
  let cNode = root;
  let inOrderArray = [];

  while (cNode || stack.length > 0) {
    while (cNode) {
      stack.push(cNode);
      cNode = cNode.left;
    }

    cNode = stack.pop();
    inOrderArray.push(cNode.val);
    cNode = cNode.right;
  }

  return inOrderArray;
};