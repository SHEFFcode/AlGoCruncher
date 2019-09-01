/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        boolean foundSelf = root.val == p.val || root.val == q.val;
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        boolean foundRight = right != null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        boolean foundLeft = left != null;

        if (foundLeft && foundRight || ((foundLeft && foundSelf) || (foundRight && foundSelf))) {
            return root;
        } else if (foundSelf) {
            return root;
        } else if (foundRight) {
            return right;
        } else if (foundLeft) {
            return left;
        } else {
            return null;
        }
    }
}

// There is a simpler solution if we assume that the other node will always be
// in the tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode l = lcaR(root.left, p, q);
        TreeNode r = lcaR(root.right, p, q);
        if (l != null && r != null)
            return root;
        if (l != null)
            return l;
        return r;
    }
}

/**
 * The key to understand here is that we want to treat any tree problem by
 * looking at a single node. So we basically have some base cases, then
 * recursive cases, and then a return case.
 * 
 * Case 1, find 2, 3: 2 / \ 1 3
 * 
 * if (cNode == null) return null; if (cNode.val == p.val || cNode.val == q.val)
 * selfNode = true bool foundRight = traverse(root.right, p, q) != null bool
 * foundLeft = traverse(root.left, p, q) != null if ((foundLeft && foundRight)
 * || (foundLeft && self || foundRight && self)) return root; // this will be
 * the final answer
 */