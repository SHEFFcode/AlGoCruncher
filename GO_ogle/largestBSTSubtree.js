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
var largestBSTSubtree = function(root) {
    return _traverse(root)[1];
};

function _traverse(cNode) {
  if (!cNode) {
    return [null, 0, 0, 0];
  }

  let leftResult = _traverse(cNode.left);
  let rightResult = _traverse(cNode.right);

    
    if (leftResult[0] === null && rightResult[0] === null) {
        return [true, 1, cNode.val, cNode.val];
    } else if (!leftResult[0] || !rightResult[0]) {
    return [false, Math.max(leftResult[1], rightResult[1]), 0, 0];
  } else {
    if (rightResult[2] > cNode.val && leftResult[3] < cNode.val) {
        
      return [true, rightResult[1] + leftResult[1] + 1, leftResult[3], rightResult[2]];
    } else {
      return [false, Math.max(rightResult[1], leftResult[1]), 0, 0];
    }
  }
}