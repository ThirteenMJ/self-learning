package weekClass.class_2021_11;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵多叉树的头节点 head
 * 保留叶子节点为黑的路径
 *
 * @author: thirteenmj
 * @date: 2022-01-04 23:14
 */
public class Code1_RetainTree {

    /**
     * 给定一棵树的头节点 head
     * 请按照题意，保留节点，没有保留的节点删掉
     * 树调整完之后，返回头节点
     *
     * @param head
     * @return
     */
    public static Node retain(Node head) {
        if (head.nexts.isEmpty()) {
            return head.retain ? head : null;
        }

        List<Node> newNexts = new ArrayList<>();

        for (Node next : head.nexts) {
            Node newNext = retain(next);
            if (newNext != null) {
                newNexts.add(newNext);
            }
        }

        if (!newNexts.isEmpty() || head.retain) {
            head.nexts = newNexts;
            return head;
        }

        return null;

    }

    public static class Node {
        /**
         * 值
         */
        public int value;
        /**
         * 是否保留
         */
        public boolean retain;
        /**
         * 下级节点
         */
        public List<Node> nexts;

        public Node(int value, boolean retain, List<Node> nexts) {
            this.value = value;
            this.retain = retain;
            this.nexts = nexts;
        }
    }

}
