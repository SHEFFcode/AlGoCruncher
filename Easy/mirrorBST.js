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
var isSymmetric = function (root) {
    //return traverseBST(root, root);
    return traverseIteratively(root);
};

let traverseBST = function (currentNode, mirrorNode) {
    if (currentNode === null) {
        return true;
    } else if (currentNode && !mirrorNode) {
        return false;
    } else if (mirrorNode && currentNode.val !== mirrorNode.val) {
        return false;
    }
    return traverseBST(currentNode.left, mirrorNode.right) && traverseBST(currentNode.right, mirrorNode.left);
};

let traverseIteratively = function (currentNode) {
    if (!currentNode) {
        return true;
    }

    let stack = [];

    /*
    Basically the idea here is to create a stack where we will have the values of the nodes in the order they appear, and we are doing some                         basic checking that the nodes that appear on the left also appear on the right.
    */
    if (currentNode.left !== null) {
        if (!currentNode.right) {
            return false;
        }
        stack.push(currentNode.left);
        stack.push(currentNode.right);
    } else if (currentNode.right !== null) {
        return false; // because we already have the currentNode.left available per above
    }

    let left, right;
    while (stack.length > 0) {
        if (stack.length % 2 !== 0) {
            return false;
        }
        right = stack.pop();
        left = stack.pop();
        if (right.val !== left.val) {
            console.log(left, right, stack);

            return false;
        }

        if (left.left !== null) {
            if (right.right === null) {

                return false;
            }
            stack.push(left.left);  // this sort of mirrors the code we had to fill up stack 
            stack.push(right.right); // before, in the code above.
        } else if (right.right !== null) {

            return false;
        }

        if (left.right !== null) {
            if (right.left === null) {

                return false;
            }
            stack.push(left.right);
            stack.push(right.left);
        } else if (right.left !== null) {
            return false;
        }
    }

    return true;
}


/*
G: Binary Tree
O: Boolean: is it a mirrored binary search tree
T: Any
S: Any

Notes:
* Bonus if you can solve recursively and iteratively

Solution:
                                    1
			/  \
      (2, 2)        2    2    (2, 2)
                    /   \  /  \
       (3,3)    3    4        4    3
                 /  \   / \      /  \  /  \
                5  6 7 8   8   7 6  5


Case1: currentNode === null:
	return true;
Case2: currentNode.val !== mirrorNode.val:
	return false;
Case3:
	return recruse(currentNode.left, mirrorNode.right) && recurse(currentNode.right, mirrorNode.left);
*/
