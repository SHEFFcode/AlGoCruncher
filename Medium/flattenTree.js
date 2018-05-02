class TreeNode {
  constructor(val) {
    this.val = val;
    this.right = null;
    this.left = null;
  }
}

function createTree(root) {

}

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
  }

  if (leftFlat) {
    leftFlat.right = root.right;
    root.right = root.left;
  }

  return leftFlat;
}