/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> collectedLeaves = new ArrayList<>(); // no reasonable default, array list good for random access

        if (root == null) {
            return collectedLeaves;
        }

        collectLeaves(root, collectedLeaves);

        return collectedLeaves;
    }

    private int collectLeaves(TreeNode cNode, List<List<Integer>> collectedLeaves) {
        if (cNode == null) {
            return 0;
        }

        int leftDistanceFromLeaf = collectLeaves(cNode.left, collectedLeaves);
        int rightDistanceFromLeaf = collectLeaves(cNode.right, collectedLeaves);
        int maxDistanceFromLeaf = Math.max(leftDistanceFromLeaf, rightDistanceFromLeaf);

        if (collectedLeaves.size() <= maxDistanceFromLeaf) { // equals here to get rid of off by one error
            collectedLeaves.add(new ArrayList<Integer>());
        }

        List<Integer> currentDistanceLeafs = collectedLeaves.get(maxDistanceFromLeaf);

        currentDistanceLeafs.add(cNode.val);

        return 1 + maxDistanceFromLeaf;
    }

}

/**
 * Input: [1,2,3,4,5]
  
      (2) 1
         / \
    (1) 2   3
       / \     
      4   5    

  Output: [[4,5,3],[2],[1]]

  [
    [4, 5, 3],
    [2],
    [1]
  ]

  The important thing to note here is that we group items based on their max distance from the leaf node
  based on distances of its left and right child.

 */