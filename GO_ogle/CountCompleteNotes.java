/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int nodeCount = 0;
    TreeNode cNode = root;

    while (cNode != null) { // danger zone here
      int leftSubtreeHeight = calculateSubtreeHeight(cNode.left);
      int rightSubtreeHeight = calculateSubtreeHeight(cNode.right);

      if (leftSubtreeHeight == rightSubtreeHeight) {
        nodeCount += 1 << rightSubtreeHeight;
        cNode = cNode.right; // we go right because we know the left subtree is full, we are now only
                             // interested in right subree
      } else { // the only other scenario is left > right, which means right is full, more
               // nodes on left.
        nodeCount += 1 << rightSubtreeHeight;
        cNode = cNode.left;
      }
    } // eventually while loop will end

    return nodeCount;
  }

  private int calculateSubtreeHeight(TreeNode cNode) {
    int subtreeHeight = 0;

    while (cNode != null) { // danger zone here
      subtreeHeight++;
      cNode = cNode.left; // we want to go as far left as possible on the subtree.
    }

    return subtreeHeight; // return the int
  }
}

// another possible solution if we cares about memory:

class Solution {
  public int countNodes(TreeNode root) {
    return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
  }
}