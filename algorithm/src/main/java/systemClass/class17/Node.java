package systemClass.class17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: thirteenmj
 * @date: 2022-11-10 11:24
 */
public class Node {

    public int value;

    public int in;

    public int out;

    public List<Node> nexts;

    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
