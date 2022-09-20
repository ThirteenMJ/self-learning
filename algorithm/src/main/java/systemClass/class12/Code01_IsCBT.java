package systemClass.class12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否是完全二叉树
 * @author: thirteenmj
 * @date: 2022-09-20 13:49
 */
public class Code01_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT1(Node head) {
        if (null == head) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            left = node.left;
            right = node.right;
            if ((leaf && (left != null || right != null))
                    || (null == left && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (null == left || null == right) {
                leaf = true;
            }
        }
        return true;
    }
}
