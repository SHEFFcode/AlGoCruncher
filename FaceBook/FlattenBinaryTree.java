class Solution {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode cNode = stack.pop();

      if (cNode.right != null) {
        stack.push(cNode.right);
      }

      if (cNode.left != null) {
        stack.push(cNode.left);
      }

      if (!stack.isEmpty()) {
        cNode.right = stack.peek();
      }

      cNode.left = null;
    }
  }
}

/**
 * 1 / \ 2 5 / \ \ 3 4 6
 * 
 * 
 * 
 * this looks a lot like a depth first search traversal on a tree with a root
 * node on a linked list 1 / \ 2 5
 * 
 * if cNode.left lList.next = cNode.left recurse(cNode.left) if cNode.right
 * lList.next = cNode.right recurse(cNode.right)
 * 
 * return lList
 * 
 */