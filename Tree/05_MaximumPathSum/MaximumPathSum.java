public class MaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        path(root);
        return max;
    }

    public int path(TreeNode root){
        if(root == null)
            return 0;
        int val = root.val;
        int left = Math.max(path(root.left), 0);
        int right = Math.max(path(root.right), 0);

        int cost = val + left + right;
        max = Math.max(max, cost);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaximumPathSum solution = new MaximumPathSum();
        assert(solution.maxPathSum(TreeNode.deserialize("1,2,3")) == 6);
        assert(solution.maxPathSum(TreeNode.deserialize("-10,9,20,null,null,15,7")) == 42);
    }
}
