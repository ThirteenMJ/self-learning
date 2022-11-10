package systemClass.class16;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 宽度优先级遍历-BFS
 * @author: thirteenmj
 * @date: 2022-11-10 11:22
 */
public class Code01_BFS {

    /**
     * 从 start 出发，进行宽度有限遍历，并打印
     * @param start
     */
    public static void bfs (Node start) {
        if (null == start) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
