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
var levelOrder = function(root) {
    return traverseTreeInOrder(root);
};

let traverseTreeInOrder = function(node) {
	if (!node) {
		return [];
    }

    let q = [node];
    let list = [];

    while (q.length > 0) {
	    let levelNum = q.length;
	    let sublist = [];
	    for (let i = 0; i < levelNum; i++) {
		    let item = q.shift();
            
            if (item) {
                q.push(item.left);
                q.push(item.right);
		        sublist.push(item.val);
            }
	    }
        if (sublist.length > 0) {
	        list.push(sublist);
        }
    }

    return list;
}





/*
   3
   / \
 9  20
     /  \
  15    7

queue = []
print: 3, 9, 20, 15, 7

*/

