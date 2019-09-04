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
        Node head = new Node();
        Node tail = findTail(root);

        runInOrderTraversalonBST(root, head, tail);

        tail.right = head;
        head.left = tail;
        return head;
    }

    private Node findTail(Node cNode) {
        while (cNode.right != null) {
            cNode = cNode.right;
        }

        return new Node(cNode.val);
    }

    private Node runInOrderTraversalonBST(Node cNode, Node head, Node tail) {
        Node llNode = new Node(cNode.val);
        if (cNode.left == null && cNode.right == null) {
            if (head.val == 0) {
                head.val = cNode.val;
                System.out.println("I am setting the head to something");
            }

            return llNode;
        }

        Node leftNode = runInOrderTraversalonBST(cNode.left, head, tail);
        llNode.left = leftNode;
        leftNode.right = llNode;
        Node rightNode = runInOrderTraversalonBST(cNode.right, head, tail);
        llNode.right = rightNode;
        rightNode.left = llNode;
        
        return rightNode;
    }
}

/**
 * We will do in order traversal of a node, but we need the head and the tail first.
 * Maybe we get the tail first, and then 
 */