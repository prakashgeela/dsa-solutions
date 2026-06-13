package trees.levelorder;


public class ConnectNextChild {

    public static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
            next = null;
        }
    }

    public Node connect(Node root) {

        if (root == null) return root;

        Node levelNode = root;

        while (levelNode != null) {
            Node dummyNode = new Node(0);
            Node currentParentNode = levelNode;
            Node currentChildNode = dummyNode;
            while (currentParentNode != null) {
                if (currentParentNode.left != null) {
                    currentChildNode.next = currentParentNode.left;
                    currentChildNode = currentChildNode.next;
                }
                if (currentParentNode.right != null) {
                    currentChildNode.next = currentParentNode.right;
                    currentChildNode = currentChildNode.next;
                }
                currentParentNode = currentParentNode.next;
            }
            levelNode = dummyNode.next;
        }
        return root;
    }


}
