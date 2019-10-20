/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(-1);
        Map<Integer, TreeNode> map = new HashMap<>();
        flipTree(root, newRoot, map);

        return newRoot;
    }

    private void flipTree(TreeNode cNode, TreeNode newRoot, Map<Integer, TreeNode> map) {
        if (cNode == null) {
            return;
        }
        if (cNode.left == null && cNode.right == null) { // since we know there will be either 2 children or 0
            if (newRoot.val == -1) {
                newRoot.val = cNode.val;
                map.put(newRoot.val, newRoot);
            }
            return;
        }

        flipTree(cNode.left, newRoot, map);
        flipTree(cNode.right, newRoot, map);

        TreeNode rightNode = map.getOrDefault(cNode.val, new TreeNode(cNode.val));
        map.put(rightNode.val, rightNode); // a little inefficient here, but still O(1)
        TreeNode leftNode;
        if (cNode.right != null) {
            leftNode = map.getOrDefault(cNode.right.val, new TreeNode(cNode.right.val));
            map.put(leftNode.val, leftNode);
        } else {
            leftNode = null;
        }
        TreeNode nRoot = map.getOrDefault(cNode.left.val, new TreeNode(cNode.left.val));
        map.put(nRoot.val, nRoot);

        nRoot.left = leftNode;
        nRoot.right = rightNode;
    }
}

/**
 * we will imagine the tree as a collection of triangles that can be rotates on a midpoint axis
 * the rotation will use a Map<Integer, TreeNode> to reuse newly created nodes.
 * We will also pass in a newRoot with a value of -1, that will signify that we have not set it yet,
 * and once we reach the leftmost node, we will set it's value as the new root.
 */

/**
 * Another solution
 class Solution {
   public TreeNode upsideDownBinaryTree(TreeNode root) {
       if (root == null || root.left == null) return root;
       
       TreeNode newRoot = upsideDownBinaryTree(root.left);
       root.left.left = root.right;
       root.left.right = root;
       root.left = null;
       root.right = null;
       return newRoot;
   }
}
 */