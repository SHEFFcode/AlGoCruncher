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
var inorderTraversal = function (root) {
  let cNode = root,
      inOrderContainer = [root.val];


  if (!cNode) {
    return inOrderContainer;
  }

  let nodeStack = [root.left, root.right];
  while (nodeStack.lenght > 0) {
    let leftNode = nodeStack.shift();
    let rightNode = nodeStack.shift();
    if (leftNode) {
      inOrderContainer.push(leftNode.val);
      inOrderContainer.push(leftNode.left);
      inOrderContainer.push(leftNode.right);
    }
    if (rightNode) {
      inOrderContainer.push(rightNode.val);
      inOrderContainer.push(rightNode.left);
      inOrderContainer.push(rightNode.right);
    }
  }
};

/*
G: TreeNode Binary Tree Head Node
O: Number[] in order traversal of its values
T: Any
S: Any

Notes:
* Do it iteratively

Solution:

Stack: [3, null]
*/