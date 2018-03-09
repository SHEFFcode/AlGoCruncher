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
var maxDepth = function(root) {
    if (root === null) {
        return 0;
    }

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
};

/*
G: Binary Tree
O: int its depth

Notes:
* There are no properties of BST that will make finding its depth less then n operation.
* Any time we are traversing a tree or an array of unkown dept we either use while loop or recursion.

Solution:
* We will use recursion here because it will be easier to write.
*/