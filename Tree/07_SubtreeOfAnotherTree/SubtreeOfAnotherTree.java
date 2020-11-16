public class SubtreeOfAnotherTree {
    SameTree util = new SameTree();

    private boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (util.isSameTree(s, t, 1) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        assert(solution.isSubtree(TreeNode.deserialize("3,4,5,1,2"), TreeNode.deserialize("4,1,2")));
        assert(!solution.isSubtree(TreeNode.deserialize("3,4,5,1,2"), TreeNode.deserialize("4,1,5")));
        assert(solution.isSubtree(TreeNode.deserialize("1,1"), TreeNode.deserialize("1")));
    }
}
