import java.util.ArrayList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> binaryTreePaths = new ArrayList<>();

        findBinaryTreePaths(root, "", binaryTreePaths);

        return binaryTreePaths;
    }

    private void findBinaryTreePaths(TreeNode root, String stringSoFar, List<String> binaryTreePaths) {
        if (root == null) {
            return;
        }
        stringSoFar += root.val;

        if (root.left == null && root.right == null) {
            binaryTreePaths.add(stringSoFar);
            return;
        }

        findBinaryTreePaths(root.left, stringSoFar + "->", binaryTreePaths);
        findBinaryTreePaths(root.right, stringSoFar + "->", binaryTreePaths);
    }
}

/**
 * 
 * 
 * 
 * Input:
 * 
 * 1 / \ 2 3 \ 5 arrayList = ["1->2", "1->3"] stringSoFar
 * 
 * (1) / \ (2) (3)
 * 
 * if (root == null) { // 1 | 3 return "" }
 * 
 * stringSoFar + (root.val) // "1->3" if (root.left || left.right) { stringSoFar
 * + ("->") // "1->3" }
 * 
 * String left = traverse(root.left, stringSoFar) // null, "1->3" => "" String
 * right = traverse(root.right, stringSoFar) // null, "1->3" => ""
 * 
 * if (left.length() == 0 && right.length == 0) { arrayList.add(stringSoFar); =>
 * // }
 * 
 * return stringSoFar left + right // "1->2"
 * 
 */