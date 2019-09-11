/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack  = new Stack<>(); // It's not most efficient but we need a stack for nulls
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cNode = stack.pop();
            if (cNode == null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("null");
            } else {
                if (sb.length() > 0) {
                    sb.append(", ");
                }

                sb.append(String.valueOf(cNode.val));
            }
            stack.push(cNode.left);
            stack.push(cNode.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] serializedNodes = data.split(", ");
        Deque<String> q = new ArrayDeque<>(serializedNodes.length); // reasonable default length
        TreeNode root = null;

        while (!q.isEmpty()) {
            String cValue = q.poll();
            TreeNode cNode = null;
            if (cValue == "null") {
                cNode = null;
            } else {
                cNode.val = Integer.parseInt(cValue);
            }

            if (root == null) {
                root = cNode;
            }

            TreeNode leftTree = null;
            cValue = q.pop();
            if (cValue == "null") {
                leftTree = null;
            } else {
                leftTree.val = Integer.parseInt(cValue);
            }

            cNode.left = leftTree;

            TreeNode rightTree = null;
            cValue = q.pop();
            if (cValue == "null") {
                rightTree = null;
            } else {
                rightTree.val = Integer.parseInt(cValue);
            }
            cNode.right = rightTree;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/**
 *                      1
 *                    /   \
 *                  2       3
 *                         / \
 *                        4   5
 * 
 * 
 * 1) Preorder traversal, so process myself, process my left process my right
 *  if (cNode.val == null) stringBuilder.length() ?  stringBuilder.append(", null") : stringBuilder.append("null")
 *  appendToSb(stringBuilder, cNode.val)
 *  traverseLeft
 *  traverseRight
 * 
 * return stringBuilder.toString()
 * 
 * [1]
 * 
 * 
 * 
 * []
 * 
 * 
 * 
 * visit nodes DFS on the left sub tree,
 *  If you have a right subtree, add the nulls, if you do not have the right subtree, do not
 * 
 * 
 * "[1,2,3,null,null,4,5]"
 * 
 * 
 */