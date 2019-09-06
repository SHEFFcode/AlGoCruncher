/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>(); // this will be a sorted map, with log(n) runtime for common
                                                           // ops
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> levelQ = new ArrayDeque<>();
        q.add(root);
        levelQ.add(0);

        while (!q.isEmpty()) {
            TreeNode cNode = q.poll();
            int level = levelQ.poll();
            List<Integer> nodesAtLevel = map.get(level);
            if (nodesAtLevel != null) {
                nodesAtLevel.add(cNode.val);
            } else {
                map.put(level, new ArrayList<>(Arrays.asList(cNode.val)));
            }

            if (cNode.left != null) {
                q.offer(cNode.left);
                levelQ.offer(level - 1);
            }

            if (cNode.right != null) {
                q.offer(cNode.right);
                levelQ.offer(level + 1);
            }

        }

        for (Map.Entry nodesAtLevel : map.entrySet()) {
            result.add((List<Integer>) nodesAtLevel.getValue());
        }

        return result;
    }
}