/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int parent = preorder[0];
    TreeNode parentNode = new TreeNode(parent);
    List<Integer> preOrderList = new ArrayList<Integer>();
    for (int index = 0; index < preorder.length; index++) {
      preOrderList.add(preorder[index]);
    }
    List<Integer> inOrderList = new ArrayList<Integer>();
    for (int index = 0; index < inorder.length; index++) {
      inOrderList.add(preorder[index]);
    }
    int indexOfParent = inOrderList.indexOf(parent);

    List<Integer> leftHalf = new ArrayList<Integer>();
    if (0 < indexOfParent - 1) {
      leftHalf = inOrderList.subList(0, indexOfParent - 1);
    }
    List<Integer> rightHalf = new ArrayList<Integer>();
    if (indexOfParent + 1 < inOrderList.size()) {
      rightHalf = inOrderList.subList(indexOfParent + 1, inOrderList.size());
    }

    TreeNode leftChild = traverse(preorder, leftHalf, 1);
    TreeNode rightChild = traverse(preorder, rightHalf, 2);
    parentNode.left = leftChild;
    parentNode.right = rightChild;

    return parentNode;
  }

  private TreeNode traverse(int[] preorder, List<Integer> inOrderList, int index) {
    if (inOrderList == null || inOrderList.size() == 0) {
      return null;
    }
    int parent = preorder[index];
    TreeNode parentNode = new TreeNode(parent);
    if (inOrderList.size() == 1) {
      return parentNode;
    }
    int indexOfParent = inOrderList.indexOf(parent);

    List<Integer> leftHalf = new ArrayList<Integer>();
    if (0 < indexOfParent - 1) {
      leftHalf = inOrderList.subList(0, indexOfParent - 1);
    }
    List<Integer> rightHalf = new ArrayList<Integer>();
    if (indexOfParent + 1 < inOrderList.size()) {
      rightHalf = inOrderList.subList(indexOfParent + 1, inOrderList.size());
    }
    TreeNode leftChild = traverse(preorder, leftHalf, index + 1);
    TreeNode rightChild = traverse(preorder, rightHalf, index + 2);
    parentNode.left = leftChild;
    parentNode.right = rightChild;
    return parentNode;
  }
}