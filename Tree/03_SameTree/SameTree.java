import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    private static final int DFS = 0;
    private static final int BFS = 1;

    public boolean isSameTree(TreeNode p, TreeNode q, int TYPE){
        switch(TYPE){
            case DFS:
                return isSameTreeDFS(p, q);
            case BFS:
                return isSameTreeBFS(p, q);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1.");
        }
    }

    private boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTreeDFS(p.left, q.left) && isSameTreeDFS(p.right, q.right);
    }

    private boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            TreeNode fst = queue.poll();
            TreeNode snd = queue.poll();

            if(fst == null && snd == null)
                continue;
            if(fst == null || snd == null || fst.val != snd.val)
                return false;

            queue.offer(fst.left);
            queue.offer(snd.left);
            queue.offer(fst.right);
            queue.offer(snd.right);
        }
        return true;
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();

        assert(solution.isSameTree(TreeNode.deserialize("1,2,3"), TreeNode.deserialize("1,2,3"), DFS));
        assert(solution.isSameTree(TreeNode.deserialize("1,2,3"), TreeNode.deserialize("1,2,3"), BFS));

        assert(!solution.isSameTree(TreeNode.deserialize("1,2"), TreeNode.deserialize("1,null,2"), DFS));
        assert(!solution.isSameTree(TreeNode.deserialize("1,2"), TreeNode.deserialize("1,null,2"), BFS));

        assert(!solution.isSameTree(TreeNode.deserialize("1,2,1"), TreeNode.deserialize("1,1,2"), DFS));
        assert(!solution.isSameTree(TreeNode.deserialize("1,2,1"), TreeNode.deserialize("1,1,2"), BFS));
    }
}
