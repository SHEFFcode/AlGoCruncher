class TraverseTreeBFS {
    // let's make a private class here to traverse some nodes
    private static class Node {
        int val;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "{val:" + val + ",left:" + left + ",right:" + right + "}";
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        createTree(root, 2, 6, 1);
        // traverseTreeBFS(root);
        System.out.println(root);
    }

    private static void createTree(Node root, int val, int max, int level) {
        Node leftNode = val <= max ? new Node() : null;
        if (leftNode == null) {
            return;
        }
        int leftAdder = (int) Math.pow(2, level); // let's get that left adder
        leftNode.val = val;
        root.left = leftNode;
        Node rightNode = val + 1 <= max ? new Node() : null;
        if (rightNode != null) {
            rightNode.val = val + 1;
        }
        int rightAdder = (int) Math.pow(2, level) * 2;
        root.right = rightNode;

        createTree(leftNode, val + leftAdder, max, level + 1);
        if (rightNode != null) {
            createTree(rightNode, val + rightAdder, max, level + 1);
        }
    }
}


/*
                    1
                  /   \  
                 2     3
               / \    /         
              4   5  6         

*/