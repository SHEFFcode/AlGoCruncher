/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {
  if (!root) {
    return []
  }
  const LRStack = [root]
  const RLStack = []
  const enclosureContainer = []
  while (LRStack.length || RLStack.length) {
    let currentLevel = []

    while (LRStack.length) {
      let cNode = LRStack.pop()
      currentLevel.push(cNode.val)
      if (cNode.left) {
        RLStack.push(cNode.left)
      }
      if (cNode.right) {
        RLStack.push(cNode.right)
      }
    }
    if (currentLevel.length) {
      enclosureContainer.push([...currentLevel])
      currentLevel.length = 0
    }

    while (RLStack.length) {
      let cNode = RLStack.pop()
      currentLevel.push(cNode.val)
      if (cNode.right) {
        LRStack.push(cNode.right)
      }
      if (cNode.left) {
        LRStack.push(cNode.left)
      }
    }
    if (currentLevel.length) {
      enclosureContainer.push([...currentLevel])
    }
  }

  return enclosureContainer
}
