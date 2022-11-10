package systemClass.class16;

import java.util.*;

/**
 * @author: thirteenmj
 * @date: 2022-11-10 16:07
 */
public class Code03_TopologySort {

    public static List<Node> sortedTopology(Graph graph) {
        // key 某个节点  value 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 只有剩余入度为 0 的点，才能进入这个队列
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
