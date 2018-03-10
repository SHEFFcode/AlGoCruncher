/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    return traverseBST(root, Number.MAX_SAFE_INTEGER, -Number.MAX_SAFE_INTEGER);
};

function traverseBST(currentNode, lessThan, largerThan) {
	if (currentNode === null) {
		return true;
	} else if (currentNode.val <= largerThan || currentNode.val >= lessThan) {
		return false;
	}

	return traverseBST(currentNode.left, Math.min(lessThan, currentNode.val), largerThan) && traverseBST(currentNode.right, lessThan, Math.max(largerThan, currentNode.val));
}

/*
Case1: root === null:
	return true;
Case2: root.val <= largerThan || root.val >= lessThan:
	return false;
Case3: root.val > largerThan || root.val < lessThan:
	return recurse(root.left, Math.min(lessThan, root.val), largerThan) && recurse(root.right, lessThan, Math.max(largerThan, root.val))

*/
