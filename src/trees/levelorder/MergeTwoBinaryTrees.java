package trees.levelorder;

import trees.levelorder.LevelOrderTraversal.TreeNode;

import java.util.Stack;



public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root1;
        if (root2 == null) return root2;

        Stack<TreeNode[]> nodeStack = new Stack<>();

        nodeStack.add(new TreeNode[] {root1, root2});

        while (!nodeStack.isEmpty()) {

            TreeNode node1 = nodeStack.pop()[0];
            TreeNode node2 = nodeStack.pop()[1];

            node1.val += node2.val;

            if (node1.left != null && node2.left != null) {
                nodeStack.add(new TreeNode[] {node1.left, node2.left});
            }

            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }

            if (node1.right != null && node2.right != null) {
                nodeStack.add(new TreeNode[] {node1.right, node2.right});
            }

            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }

        return root1;
    }

    public static void main(String[] args) {

    }

}
