package systemClass.class17;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图结构
 * @author: thirteenmj
 * @date: 2022-11-10 12:01
 */
public class Graph {
    public HashMap<Integer, Node> nodes;

    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
