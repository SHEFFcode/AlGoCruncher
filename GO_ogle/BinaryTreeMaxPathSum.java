class Solution {
  public int maxPathSum(TreeNode root) {
    int[] prevSumAndMax = { 0, Integer.MIN_VALUE };
    findMaxPathSum(root, prevSumAndMax);
    return prevSumAndMax[1];
  }

  private int[] findMaxPathSum(TreeNode cNode, int[] prevSumAndMax) {
    if (cNode == null) {
      prevSumAndMax[0] = 0; // no need to update max here.
      return prevSumAndMax;
    }
    int left = Math.max(0, findMaxPathSum(cNode.left, prevSumAndMax)[0]); // we only care about left and right if they
                                                                          // are positive
    int right = Math.max(0, findMaxPathSum(cNode.right, prevSumAndMax)[0]);

    if (cNode.left != null && cNode.right != null) {
      prevSumAndMax[1] = Math.max(prevSumAndMax[1], left + right + cNode.val); // max has to go through cNode and left
                                                                               // and right if they are positive
      prevSumAndMax[0] = Math.max(left, right) + cNode.val; // we will go through the highest of the children
      return prevSumAndMax;
    } else if (cNode.left == null) {
      prevSumAndMax[1] = Math.max(prevSumAndMax[1], right + cNode.val);
      prevSumAndMax[0] = right + cNode.val; // we will go through whichever child is not null
      return prevSumAndMax;
    } else {
      prevSumAndMax[1] = Math.max(prevSumAndMax[1], left + cNode.val); // we will go through whichever child is not null
      prevSumAndMax[0] = left + cNode.val;
      return prevSumAndMax;
    }
  }

}