package systemClass.class16;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先级遍历-DFS
 * @author: thirteenmj
 * @date: 2022-11-10 11:43
 */
public class Code02_DFS {

    public static void dfs(Node start){
        if (null == start) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.add(start);
        set.add(start);
        System.out.println(start.value);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    stack.add(node);
                    stack.add(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
