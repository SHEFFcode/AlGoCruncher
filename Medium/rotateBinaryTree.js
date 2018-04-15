/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    if (!root || root.val === null) {
      return;
    }
    traverse(root);
    return root;
};

function traverse(cNode) {
  if (!cNode) {
    return;
  }

  let tempLeft = cNode.left;
  cNode.left = cNode.right;
  cNode.right = tempLeft;

  traverse(cNode.right);
  traverse(cNode.left);
}