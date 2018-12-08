import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode levelStart = root;
    while (levelStart != null) {
      TreeLinkNode cNode = levelStart;
      while (cNode != null) {
        if (cNode.left != null) {
          cNode.left.next = cNode.right;
        }
        if (cNode.right != null && cNode.next != null) {
          cNode.right.next = cNode.next.left;
        }

        cNode = cNode.next;
      }
      if (levelStart.left != null) {
        levelStart = levelStart.left;
      } else if (levelStart.right != null) {
        levelStart = levelStart.right;
      } else {
        levelStart = null;
      }

    }
  }
}