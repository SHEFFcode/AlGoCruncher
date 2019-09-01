/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> q = new LinkedList<>(); // we do not have a reasonable initial size, so we'll go w/default
        q.offer(node); // let's pop in the root node.
        Map<Node, Node> originalToCloneMapping = new HashMap<>(); // we do not have a reasonable size, so default
        originalToCloneMapping.put(node, new Node(node.val, new ArrayList<>()));

        while (!q.isEmpty()) { // DANGER ZONE, make sure that q size can reach zero
            Node cNode = q.poll(); // cNode

            cNode.neighbors.forEach(neighbor -> {
                if (!originalToCloneMapping.containsKey(neighbor)) {
                    Node clonedNeighbor = new Node(neighbor.val, new ArrayList<Node>());

                    originalToCloneMapping.put(neighbor, clonedNeighbor);
                    q.offer(neighbor);
                }

                originalToCloneMapping.get(cNode).neighbors.add(originalToCloneMapping.get(neighbor));
            });
        }

        return originalToCloneMapping.get(node);
    }
}

/**
 * The key to realize here is that since we want to recreate neighbor
 * relationships it's best to use a BFS with a queue. Another important
 * realization is that we want to have a mapping between the originalNodes and
 * the cloneNodes. This is best done with a hashtable.
 * 
 */