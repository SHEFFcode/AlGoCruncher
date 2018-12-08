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
      levelStart = levelStart.left;
      if (levelStart == null) {
        levelStart = levelStart.right;
      }
    }
  }
}