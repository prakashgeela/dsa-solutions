package trees.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {


    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public List<Integer> inOrderTraversal(Node root) {

        Stack<Node> inOrderStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        Node temp = root;


        while (temp != null || !inOrderStack.isEmpty()) {

            while (temp != null) {
                inOrderStack.push(temp);
                temp = temp.left;
            }

            Node poppedNode = inOrderStack.pop();
            result.add(poppedNode.value);

            if (poppedNode.right != null) {
                temp = poppedNode.right;
            }

        }

        return result;

    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.left.left = new Node(6);

        node.right = new Node(3);
        node.right.right = new Node(7);
        node.right.right.left = new Node(8);

        InOrderTraversalIterative inOrderTraversalIterative = new InOrderTraversalIterative();

        List<Integer> result = inOrderTraversalIterative.inOrderTraversal(node);

        System.out.print(result);
    }
}
