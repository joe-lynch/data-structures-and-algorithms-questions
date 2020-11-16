
public class InvertBinaryTree {

    private TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();
        SameTree util = new SameTree();

        TreeNode originalTree1 = TreeNode.deserialize("4,2,7,1,3,6,9");
        TreeNode invertedTree1 = TreeNode.deserialize("4,7,2,9,6,3,1");
        TreeNode invertedSoln1 = solution.invertTree(originalTree1);
        assert(util.isSameTree(invertedSoln1, invertedTree1, 1));

        TreeNode originalTree2 = TreeNode.deserialize("1,2,1");
        TreeNode invertedTree2 = TreeNode.deserialize("1,2,1");
        TreeNode invertedSoln2 = solution.invertTree(originalTree2);
        assert(!util.isSameTree(invertedSoln2, invertedTree2, 1));
    }
}
