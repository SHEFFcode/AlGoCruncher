/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightSideView = new LinkedList<>();
    if (root == null) {
      return rightSideView;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode cNode = q.remove();
        if (i == size) {
          rightSideView.add(cNode.val);
        }

        if (cNode.left != null) {
          q.add(cNode.left);
        }

        if (cNode.right != null) {
          q.add(cNode.right);
        }
      }
    }

    return rightSideView;
  }
}

/**
 * Since the question asks top to bottom, it immediately indicates breadth first
 * search DFS entails a stack BFS entails a queue
 * 
 * 
 * 
 * 
 */

// 1 <---
// / \
// 2 3 <---
// \ \
// 5 4 <---