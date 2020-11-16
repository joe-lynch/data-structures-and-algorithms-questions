import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    private static final int RECURSIVE = 0;
    private static final int ITERATIVE = 1;

    private TreeNode invertTree(TreeNode root, int TYPE){
        switch (TYPE){
            case RECURSIVE:
                return invertTreeRecursive(root);
            case ITERATIVE:
                return invertTreeIterative(root);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1");
        }
    }

    private TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
        return root;
    }

    private TreeNode invertTreeIterative(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode p = q.poll();
            TreeNode tmp = p.left;
            p.left = p.right;
            p.right = tmp;
            if(p.left != null)
                q.offer(p.left);
            if(p.right != null)
                q.offer(p.right);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();
        SameTree util = new SameTree();

        /* First case, inverts using both recursive and iterative */
        TreeNode originalTree1 = TreeNode.deserialize("4,2,7,1,3,6,9");
        TreeNode invertedTree1 = TreeNode.deserialize("4,7,2,9,6,3,1");
        TreeNode recurSoln1 = solution.invertTree(originalTree1, RECURSIVE);
        TreeNode iterSoln1 = solution.invertTree(originalTree1, ITERATIVE);
        /* Use isSameTree method of SameTree class, to ensure the inverted tree is correct */
        assert(util.isSameTree(recurSoln1, invertedTree1, 1));
        assert(util.isSameTree(iterSoln1, invertedTree1, 1));

        /* Second case, inverts using both recursive and iterative */
        TreeNode originalTree2 = TreeNode.deserialize("1,2,1");
        TreeNode invertedTree2 = TreeNode.deserialize("1,2,1");
        TreeNode recurSoln2 = solution.invertTree(originalTree1, RECURSIVE);
        TreeNode iterSoln2 = solution.invertTree(originalTree1, ITERATIVE);
        /* Use isSameTree method of SameTree class, to ensure the inverted tree is correct */
        assert(!util.isSameTree(recurSoln2, invertedTree2, 1));
        assert(!util.isSameTree(iterSoln2, invertedTree2, 1));
    }
}
