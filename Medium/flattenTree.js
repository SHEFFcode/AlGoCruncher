/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function (root) {
  flattenTree(root);
};

function flattenTree(root) {
  if (!root) {
    return root;
  }
  if (root.left === null && root.right === null) {
    return root;
  }

  let leftFlat = null, rightFlat = null;

  if (root.left) {
    leftFlat = flattenTree(root.left);
    if (leftFlat) {
      leftFlat.right = root.right;

    }
    root.right = root.left;
    root.left = null;
  }

  if (root.right) {
    rightFlat = flattenTree(root.right);
  }

  while (leftFlat && leftFlat.right) {
    leftFlat = leftFlat.right;
  }

  return leftFlat || rightFlat;
}