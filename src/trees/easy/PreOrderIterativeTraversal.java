package trees.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterativeTraversal {

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

    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodesStack = new Stack<>();
        TreeNode curr = root;

        if (curr == null) return result;

        treeNodesStack.push(root);

        while (!treeNodesStack.isEmpty()) {
            TreeNode node = treeNodesStack.pop();
            result.add(node.val);

            if (node.right != null) treeNodesStack.push(node.right);
            if (node.left != null) treeNodesStack.push(node.left);
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

        PreOrderIterativeTraversal preOrderIterativeTraversal = new PreOrderIterativeTraversal();

        List<Integer> result = preOrderIterativeTraversal.preOrderTraversal(node);

        System.out.print(result);
    }
}
