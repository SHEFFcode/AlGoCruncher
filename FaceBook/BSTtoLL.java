/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Node[] headTail = new Node[2]; // in the end the array will represent head and tail

        runInOrderTraversalonBST(root, headTail);

        headTail[1].right = headTail[0]; // let's update the head tail relationship
        headTail[0].left = headTail[1];

        return headTail[0];
    }

    private void runInOrderTraversalonBST(Node cNode, Node[] headPrev) { // here the array represents head and previous
                                                                         // visited node
        if (cNode != null) {
            runInOrderTraversalonBST(cNode.left, headPrev); // this will traverse all the way to the left most element,
                                                            // finding
            // the head

            if (headPrev[1] != null) { // we explored at least one node
                headPrev[1].right = cNode;
                cNode.left = headPrev[1];
            } else { // this means we are at the very leftmost node
                headPrev[0] = cNode; // we have found the head
            }

            headPrev[1] = cNode; // let's update the previous node
            runInOrderTraversalonBST(cNode.right, headPrev); // let's explore the right subtree
        }
    }
}

/**
 * We will do in order traversal of a node, but we need the head and the tail
 * first. Maybe we get the tail first, and then
 */