/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} target
 * @return {number}
 */
var closestValue = function(root, target) {
  if (root.val === target) {
      return root.val;
  }
  let candidates = [];
  traverseTree(root, target, candidates);
   return candidates[0];
};

function traverseTree(cNode, target, candidates) {
  if (candidates.length === 0 || Math.abs(target - candidates[0]) > Math.abs(target - cNode.val)) {
      candidates[0] = cNode.val;
  }
  
  if (target > cNode.val && cNode.right) {
      traverseTree(cNode.right, target, candidates);
  } else if (target < cNode.val && cNode.left) {
      traverseTree(cNode.left, target, candidates)
  }
}