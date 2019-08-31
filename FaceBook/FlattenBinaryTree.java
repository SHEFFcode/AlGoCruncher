import java.util.LinkedList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public void flatten(TreeNode root) {
    if (root == null)
      return;

    flatten(root.left);
    flatten(root.right);
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;
    root.right = left;
    while (root.right != null)
      root = root.right;
    root.right = right;
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