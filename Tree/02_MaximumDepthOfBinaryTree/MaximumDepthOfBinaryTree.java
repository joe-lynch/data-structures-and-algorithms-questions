import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    private static final int DFS = 0;
    private static final int BFS = 1;

    public int maxDepth(TreeNode root, int TYPE){
        switch(TYPE){
            case DFS:
                return maxDepthDFS(root);
            case BFS:
                return maxDepthBFS(root);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1");
        }
    }

    public int maxDepthDFS(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)) + 1;
    }

    public int maxDepthBFS(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while(!q.isEmpty()){
            int level_size = q.size();
            while(level_size-- != 0){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        assert(solution.maxDepth(TreeNode.deserialize("3,9,20,null,null,15,7"), BFS) == 3);
        assert(solution.maxDepth(TreeNode.deserialize("3,9,20,null,null,15,7"), DFS) == 3);
    }
}
