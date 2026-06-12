package trees.medium;

import java.util.ArrayList;
import java.util.List;
import trees.medium.PathSum2.TreeNode;

public class BinaryTreeRightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        rightSideView(root, result, 0);
        return result;
    }

    public void rightSideView(TreeNode root, List<Integer> result,
                              int level) {

        if (root == null) return;

        if (result.size() == level) {
            result.add(root.val);
        }

        rightSideView(root.right, result, level+1);
        rightSideView(root.left, result, level+1);
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(binaryTreeRightSideView.rightSideView(root));
    }



}
