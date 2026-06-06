package trees.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public List<Integer> postOrderTraversal(TreeNode root) {

        Stack<TreeNode> workerStack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        workerStack.push(root);

        while (!workerStack.isEmpty()) {
            TreeNode curr = workerStack.pop();
            resultStack.push(curr);
            if (curr.left != null) workerStack.push(curr.left);
            if (curr.right != null) workerStack.push(curr.right);
        }

        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop().val);
        }

        return result;
    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);


        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(7);
        node.right.right.left = new TreeNode(8);

        PostOrderTraversalIterative postOrderTraversalIterative = new PostOrderTraversalIterative();

        System.out.print(postOrderTraversalIterative.postOrderTraversal(node));
    }
}
