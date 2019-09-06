import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>(); // this will be a sorted map, with log(n) runtime for common
                                                           // ops
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverseAndPopulateMap(root, map, 0);

        for (Map.Entry nodesAtLevel : map.entrySet()) {
            result.add((List<Integer>) nodesAtLevel.getValue());
        }

        return result;
    }

    private void traverseAndPopulateMap(TreeNode cNode, Map<Integer, List<Integer>> map, int level) {
        if (cNode != null) {
            List<Integer> nodesAtLevel = map.get(level);
            if (nodesAtLevel != null) {
                nodesAtLevel.add(cNode.val);
            } else {
                map.put(level, new ArrayList<>(Arrays.asList(cNode.val)));
            }
            traverseAndPopulateMap(cNode.left, map, level - 1);
            traverseAndPopulateMap(cNode.right, map, level + 1);
        }
    }
}