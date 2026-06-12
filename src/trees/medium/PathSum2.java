package trees.medium;


import trees.easy.PostOrderTraversalIterative;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        pathSum(root, targetSum, temp, result);

        return result;
    }

    public void pathSum(TreeNode root, int targetSum, ArrayList<Integer> list,
                                       List<List<Integer>> result) {
        if (root == null) return;

        list.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(List.copyOf(list));
        } else {
            pathSum(root.left, targetSum - root.val, list, result);
            pathSum(root.right, targetSum - root.val, list, result);
        }

        list.remove(list.size()-1);
    }

    public static void main(String[] args) {

        PathSum2 pathSum2 = new PathSum2();

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.right = new TreeNode(6);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);

        List<List<Integer>> result = pathSum2.pathSum(treeNode, 22);

        System.out.println(result);

    }


}
