import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int preIndex;

  public Solution() {
    this.preIndex = 0;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) {
      return null;
    }
    int start = 0;
    int end = inorder.length - 1;
    Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>(); // this map will save us the index of item
                                                                        // search
    for (int i = 0; i < inorder.length; i++) {
      inOrderMap.put(inorder[i], i);
    }
    return traverseTree(inorder, preorder, start, end, inOrderMap);
  }

  protected TreeNode traverseTree(int[] in, int[] pre, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
    if (inStart < 0 || inStart > inEnd) {
      return null;
    }

    int currentItem = pre[this.preIndex++];
    TreeNode tNode = new TreeNode(currentItem);

    if (inStart == inEnd) {
      return tNode;
    }

    int indexOfItem = inOrderMap.get(currentItem); // this is where we save the index of item search
    tNode.left = traverseTree(in, pre, inStart, indexOfItem - 1, inOrderMap);
    tNode.right = traverseTree(in, pre, indexOfItem + 1, inEnd, inOrderMap);

    return tNode;
  }
}