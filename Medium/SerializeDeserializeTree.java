import java.util.List;
import java.util.ArrayList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    } else if (root.left == null || root.right == null) {
      return "[" + root.val + "]";
    }

    List<TreeNode> nodes = new ArrayList<>();
    StringBuilder serializedTree = new StringBuilder("[");
    TreeNode cNode = root;
    nodes.add(cNode);

    while (!nodes.isEmpty()) {
      cNode = nodes.remove(nodes.size() - 1);
      serializedTree.append("," + cNode.val);
      if (cNode.left != null) {
        nodes.add(cNode.left);
      }
      if (cNode.right != null) {
        nodes.add(cNode.right);
      }
    }

    return serializedTree.append("]").toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));