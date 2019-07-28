import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1.val != root2.val) {
      return false;
    }

    Queue<TreeNode> q1 = new LinkedList<>(); // Default size for now
    Queue<TreeNode> q2 = new LinkedList<>();
    q1.offer(root1);
    q2.offer(root2);

    while (!q1.isEmpty() && !q2.isEmpty()) {
      TreeNode cNode1 = q1.poll();
      TreeNode cNode2 = q2.poll();

      if (isFlippable(cNode1, cNode2)) {
        enqueue(cNode1, cNode2, q1, q2); // we can have different implementations here in the future if need be.
      } else {
        return false; // if we are not flippable, let's short circuit here
      }
    }

    return true; // If we reach the end here we will return true.
  }

  private boolean isFlippable(TreeNode cNode1, TreeNode cNode2) {
    int[] vals1 = populateVals(cNode1);
    int[] vals2 = populateVals(cNode2);

    Arrays.sort(vals1);
    Arrays.sort(vals2);

    return Arrays.equals(vals1, vals2);
  }

  private int[] populateVals(TreeNode cNode) {
    int[] vals = new int[2];
    vals[0] = cNode.right ? cNode.right.val : -1;
    vals[1] = cNode.left ? cNode.left.val : -1;

    return vals;
  }

  private void enqueue(TreeNode cNode1, TreeNode cNode2, Queue<TreeNode> q1, Queue<TreeNode> q2) {
    if (cNode1.left != null) {
      q1.offer(cNode1.left.val);
      if (cNode2.left != null) {
        if (cNode2.left.val == cNode1.left.val) {
          q2.offer(cNode2.left.val);
        } else {
          q2.offer(cNode2.right.val); // must exist because cNode1.left is not null and it is flippable.
        }
      }
    } // if it was null, there is no point of adding it to the queue.

    if (cNode1.right != null) {
      q1.offer(cNode1.right.val);
      if (cNode2.right != null) {
        if (cNode2.right.val == cNode1.right.val) {
          q2.offer(cnode2.right.val);
        } else {
          q2.offer(cNode2.left.val); // must exist because cNode1.left is not null and it is flippable.
        }
      }
    }
  }
}