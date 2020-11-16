import java.util.*;

public class LevelOrderTraversal {
    private static final int DFS = 0;
    private static final int BFS = 1;


    public List<List<Integer>> levelOrder(TreeNode root, int TYPE){
        switch(TYPE){
            case BFS:
                levelOrderBFS(root);
            case DFS:
                levelOrderDFS(root);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1.");
        }
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        list.add(new ArrayList<>());

        int lvl = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                lvl++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
            else{
                if(list.size()-1 != lvl)
                    list.add(new ArrayList<>());

                list.get(lvl).add(curr.val);

                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root){
        return null;
    }

    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();

        List<List<Integer>> ans = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));
        //List<List<Integer>> soln = solution.levelOrder(TreeNode.deserialize("3,9,20,null,null,15,7"), DFS);
        List<List<Integer>> soln = solution.levelOrder(TreeNode.deserialize("3,9,20,null,null,15,7"), BFS);

        assert(soln.equals(ans));
    }
}
