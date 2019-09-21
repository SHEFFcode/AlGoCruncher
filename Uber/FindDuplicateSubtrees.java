import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    int nextUid = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicateNodes = new ArrayList<>(); // i don't have a good default size
        Map<String, Integer> serializationToUidMap = new HashMap<>(); // no default size
        Map<Integer, Integer> uidFrequencyMap = new HashMap<>(); // no default size

        lookUpSerialization(root, serializationToUidMap, uidFrequencyMap, duplicateNodes);

        return duplicateNodes;
    }

    private int lookUpSerialization(TreeNode cNode, Map<String, Integer> serializationToUidMap,
            Map<Integer, Integer> uidFrequencyMap, List<TreeNode> duplicateNodes) {
        if (cNode == null) {
            return -1;
        }

        String serialization = cNode.val + ","
                + lookUpSerialization(cNode.left, serializationToUidMap, uidFrequencyMap, duplicateNodes) + ","
                + lookUpSerialization(cNode.right, serializationToUidMap, uidFrequencyMap, duplicateNodes);

        int uid = serializationToUidMap.computeIfAbsent(serialization, x -> nextUid++);
        uidFrequencyMap.merge(uid, 1, Integer::sum);

        if (uidFrequencyMap.get(uid) == 2) { // we only care about frequency of 2
            System.out.println("Adding node...");
            duplicateNodes.add(cNode); // each node will represent a subtree.
        }

        return uid; // let's return uid for next iteration
    }
}

/**
 * 
 *      1
       / \
      2   3
     /   / \
    4   2   4
       /
      4


    leaf nodes can create their own subtree

    nextUid = 4;

    duplicateNodes: [Node(4), Node(2)]

    serializationToUidMap: {
        "4,#,#": 1,
        "2,4,#,#,#": 2,
        "3,2,4,#,#,#,4,#,#": 3,
        "1,2,4,#,#,#3,2,4,#,#,#,4,#,#": 4
    }

    uidFrequencyMap: {
        1: 3, // we don't care about anything over 2, just about 2 which is a def of a duplicate
        2: 2,
        3: 1,
        4: 1
    }

 */