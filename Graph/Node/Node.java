import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int val,List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}