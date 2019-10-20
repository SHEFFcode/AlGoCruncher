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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return findHelper(root, root.val);
    }

    private int findHelper(TreeNode cNode, int min) {
        if (cNode == null) {
            return -1;
        }

        if (cNode.val > min) {
            return cNode.val;
        }

        int left = findHelper(cNode.left, min);
        int right = findHelper(cNode.right, min);
        int minLeftRight = Math.min(left, right);
        int ans = -1; // we be initialized to 0

        if (minLeftRight == -1) {
            ans = Math.max(left, right);
        } else {
            ans = minLeftRight;
        }

        return ans;
    }
}

/**
 * Because we know that the root will be the smallest of it's two subtree,
 * we don't need to process all of subtrees. We will return the next highest value,
 * and then do a tie braker between the two children nodes.
 */