public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBST solution = new LowestCommonAncestorOfBST();
        SameTree util = new SameTree();

        TreeNode ans1 = TreeNode.deserialize("6,2,8,0,4,7,9,null,null,3,5");
        TreeNode soln1 = solution.lowestCommonAncestor(
                TreeNode.deserialize("6,2,8,0,4,7,9,null,null,3,5"),
                TreeNode.deserialize("2,0,4,null,null,3,5"),
                TreeNode.deserialize("8,7,9")
        );
        assert(util.isSameTree(ans1, soln1, 1));

        TreeNode ans2 = TreeNode.deserialize("2,0,4,null,null,3,5");
        TreeNode soln2 = solution.lowestCommonAncestor(
                TreeNode.deserialize("6,2,8,0,4,7,9,null,null,3,5"),
                TreeNode.deserialize("2,0,4,null,null,3,5"),
                TreeNode.deserialize("4,3,5")
        );
        assert(util.isSameTree(ans2, soln2, 1));


        TreeNode ans3 = TreeNode.deserialize("2,1");
        TreeNode soln3 = solution.lowestCommonAncestor(
                TreeNode.deserialize("2,1"),
                TreeNode.deserialize("2,1"),
                TreeNode.deserialize("1")
        );
        assert(util.isSameTree(ans3, soln3, 1));


    }
}
