package systemClass.class17;

/**
 * @author: thirteenmj
 * @date: 2022-11-10 11:26
 */
public class Edge {

    public int weight;

    public Node from;

    public Node to;

    public Edge() {
    }

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
