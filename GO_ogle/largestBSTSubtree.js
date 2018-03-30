


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var largestBSTSubtree = function (root) {
  let result = _traverse(root);
  if (result[4] === 1) {
    return result[1] + 1;
  }
  return result[1];
};

function _traverse(cNode, depth = 0) {
  if (!cNode) {
    return [null, 0, 0, 0, depth];
  }

  let leftResult = _traverse(cNode.left, depth + 1);
  let rightResult = _traverse(cNode.right, depth + 1);

  console.log(leftResult);
  console.log(rightResult);

  if (leftResult[0] === null && rightResult[0] === null) {
    return [true, 1, cNode.val, cNode.val, depth];
  } else if (leftResult[0] === false || rightResult[0] === false) {
    return [false, Math.max(leftResult[1], rightResult[1]), 0, 0, Math.max(leftResult[4], rightResult[4])];
  } else {
    if (rightResult[2] > cNode.val && leftResult[3] < cNode.val) {
      if (rightResult[4] === 1) {
        rightResult[1] += 1;
      } else if (leftResult[4] === 1) {
        leftResult[1] += 1;
      }
      return [true, rightResult[1] + leftResult[1] + 1, leftResult[3], rightResult[2], Math.max(leftResult[4], rightResult[4])];
    } else {
      return [false, Math.max(rightResult[1], leftResult[1]), 0, 0, Math.max(leftResult[4], rightResult[4])];
    }
  }
}