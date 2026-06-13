package trees.easy;

public class MaxDepthOfBT {

    public int maxDepth(PostOrderTraversalIterative.TreeNode root) {

        if (root == null) return 0;

        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);

        return Math.max(lHeight, rHeight)+1;
    }

    public static void main(String[] args) {
        PostOrderTraversalIterative.TreeNode node = new PostOrderTraversalIterative.TreeNode(1);


        node.left = new PostOrderTraversalIterative.TreeNode(2);
        node.left.left = new PostOrderTraversalIterative.TreeNode(4);
        node.left.right = new PostOrderTraversalIterative.TreeNode(5);
        node.left.left.left = new PostOrderTraversalIterative.TreeNode(6);

        node.right = new PostOrderTraversalIterative.TreeNode(3);
        node.right.right = new PostOrderTraversalIterative.TreeNode(7);
        node.right.right.left = new PostOrderTraversalIterative.TreeNode(8);

        MaxDepthOfBT maxDepthOfBT = new MaxDepthOfBT();
        System.out.println(maxDepthOfBT.maxDepth(node));
    }
}
