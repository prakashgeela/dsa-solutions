package trees.levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public List<List<Integer>> getLevelOrderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            int size = nodeQueue.size();

            for (int i = 1 ; i <= size ; i++) {

                TreeNode node = nodeQueue.poll();

                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);

                tempList.add(node.val);
            }

            result.add(tempList);

        }

        return result;
    }

    public static void main(String[] args) {

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        // root = [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderTraversal.getLevelOrderTraversal(root));
    }
}
