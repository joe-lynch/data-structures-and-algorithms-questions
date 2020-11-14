import java.util.*;

public class CloneGraph {
    private static final int DFS = 0;
    private static final int BFS = 1;
    private Map<Node, Node> visitedDFS = new HashMap<>();

    private Node cloneGraph(Node node, int TYPE){
        if(TYPE == 0){
            visitedDFS.clear();
            return cloneDFS(node);
        }
        else if (TYPE == 1){
            return cloneBFS(node);
        }
        else{
            throw new IllegalArgumentException("TYPE must be either 0 or 1.");
        }
    }

    private Node cloneDFS(Node node) {
        if(node == null){
            return null;
        }
        if(visitedDFS.containsKey(node)){
            return visitedDFS.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<>());
        visitedDFS.put(node, copy);

        for(Node nei : node.neighbors){
            copy.neighbors.add(cloneDFS(nei));
        }
        return copy;
    }

    private Node cloneBFS(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        visited.put(node, new Node(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node nei : curr.neighbors){
                if(!visited.containsKey(nei)){
                    visited.put(nei, new Node(nei.val, new ArrayList<>()));
                    q.add(nei);
                }
                visited.get(curr).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // create initial graph
        Node one = new Node(1, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node three = new Node(3, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());

        one.neighbors.addAll(Arrays.asList(two, four));
        two.neighbors.addAll(Arrays.asList(one, three));
        three.neighbors.addAll(Arrays.asList(two, four));
        four.neighbors.addAll(Arrays.asList(one, three));

        // use dfs method
        Node copyDFS = solution.cloneGraph(one, DFS);

        // use bfs method
        Node copyBFS = solution.cloneGraph(one, BFS);
    }
}
