import java.util.ArrayDeque;
import java.util.List;

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> res = new ArrayDeque<>();
        inOrder(root, target, k, res); // we will use in order traversal
        return new LinkedList<>(res);
    }

    private void inOrder(TreeNode root, double target, int k, Queue<Integer> res) {
        if (root == null)
            return;
        inOrder(root.left, target, k, res);
        if (res.size() < k) {
            res.offer(root.val);
        } else if (Math.abs(root.val - target) <= Math.abs(res.peek() - target)) {
            res.poll();
            res.offer(root.val);
        }
        inOrder(root.right, target, k, res);
    }

}

/**
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]
 */