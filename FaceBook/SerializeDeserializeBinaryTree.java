/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null, ";
        }

        String current = "" + root.val + ", ";
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);


        return current + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(", ");
        Queue<String> q = new ArrayDeque<>();
        q.addAll(Arrays.asList(nodes));
        

        return deserializeImpl(q);
    }

    private TreeNode deserializeImpl(Queue<String> q) {
        String nodeValue = q.poll();
        if (nodeValue.equals("null")) {
            return null;
        }

        TreeNode cNode = new TreeNode(Integer.parseInt(nodeValue));
        cNode.left = deserializeImpl(q);
        cNode.right = deserializeImpl(q);

        return cNode;
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