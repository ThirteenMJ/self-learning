package beginClass.class04;

import java.util.ArrayList;

/**
 * 给一个链表，要求返回顺序倒过来的值
 *
 * @author: thirteenmj
 * @date: 2022-01-26 16:44
 */
public class Code01_ReverseList {

    /**
     * 单链表结构
     */
    public static class Node {

        public Node next;

        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 双链表结构
     */
    public static class DoubleNode {

        public int value;

        public DoubleNode pre;

        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     *
     *
     * @param head
     * @return
     */
    private static Node revertLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static DoubleNode revertDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        ArrayList<Node> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int length = list.size();
        for (int i = 1; i < length; i++) {
            list.get(i).next = list.get(i -1);
        }
        return list.get(length - 1);
    }

    private static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<DoubleNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        int length = list.size();
        for (int i = 0; i < length; i++) {
            DoubleNode cur = list.get(i);
            pre = cur.pre;
            next = cur.next;
            cur.pre = next;
            cur.next = pre;
        }
        return list.get(length - 1);
    }


    private static DoubleNode generateDoubleList(int maxValue, int maxLength) {
        int length = (int) (maxLength * Math.random() + 1);

        if (length > 0) {
            DoubleNode head = new DoubleNode((int) (maxValue * Math.random() + 1));
            DoubleNode pre = null;
            DoubleNode next = head;

            for (int i = 1; i < length; i++) {
                DoubleNode node = new DoubleNode((int) (maxValue * Math.random() + 1));
                node.pre = next;
                next.next = node;
                next.pre = pre;
                pre = next;
                next = next.next;
            }
            return head;
        }
        return null;
    }


    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxLength = 100;

        for (int i = 0; i < testTime; i++) {

            Node head = generateLinkedList(maxValue, maxLength);
            Node result1 = revertLinkedList(head);
            Node result2 = testReverseLinkedList(result1);
            if (!isEqualsForLinkedList(head, result2)) {
                System.out.println("垃圾");
                System.out.print("原单链条：");
                printLikedList(head);
                System.out.println("现单链条:");
                printLikedList(result2);
                return;
            }


        }
        System.out.println("单链条测试通过");
        for (int i = 0; i < testTime; i++) {
            DoubleNode head = generateDoubleList(maxValue, maxLength);
            DoubleNode result1 = revertDoubleList(head);
            DoubleNode result2 = testReverseDoubleList(result1);
            if (!isEqualsForDoubleList(head, result2)) {
                System.out.println("双链表出错");
                System.out.println("原双链条：");
                printDoubleList(head);
                System.out.println("现双链条：");
                printDoubleList(result2);
                return;
            }

        }

        System.out.println("双链表测试通过");

    }

    /**
     * 判断单链表是否相同
     *
     * @param firstNode
     * @param secondNode
     * @return
     */
    private static boolean isEqualsForLinkedList(Node firstNode, Node secondNode) {
        while (firstNode != null && secondNode != null) {
            if (firstNode.value != secondNode.value) {
                return false;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return null == firstNode && null == secondNode;
    }

    /**
     * 判断双链表是否相同
     *
     * @param node1
     * @param node2
     * @return
     */
    private static boolean isEqualsForDoubleList(DoubleNode node1, DoubleNode node2) {
        boolean isNull1 = node1 == null;
        boolean isNull2 = node2 == null;
        if (isNull1 && isNull1) {
            return true;
        }
        if (isNull1 || isNull2) {
            return false;
        }

        if (node1.pre != null || node2.pre != null) {
            return false;
        }

        DoubleNode end1 = null;
        DoubleNode end2 = null;

        while (node1 != null && node2 != null) {
            if (node1.value != node2.value) {
                return false;
            }

            end1 = node1;
            end2 = node2;

            node1 = node1.next;
            node2 = node2.next;
        }

        if (node1 != null || node2 != null) {
            return false;
        }

        while (end1 != null && end2 != null) {
            if (end1.value != end2.value) {
                return false;
            }
            end1 = end1.pre;
            end2 = end2.pre;
        }

        return null == end1 && null == end2;

    }


    /**
     * 打印链表结构
     *
     * @param node
     */
    private static void printLikedList(Node node) {
        System.out.print("链表：");
        if (node != null) {
            Node temp = node;
            while (temp != null) {
                System.out.print(" " + temp.value);
                temp = temp.next;
            }
        }
        System.out.println();
    }

    /**
     * 生成一个单链表结构
     *
     * @param maxValue
     * @param maxLength
     * @return
     */
    private static Node generateLinkedList(int maxValue, int maxLength) {
        int length = (int) (maxLength * Math.random() + 1);

        if (length == 0) {
            return null;
        }

        length--;
        Node head = new Node((int) ((maxValue * Math.random()) + 1) - (int) ( maxValue * Math.random()));
        Node pre = head;
        for (int i = 1; i < length; i++) {
            Node node = new Node((int) ((maxValue * Math.random()) + 1) - (int) ( maxValue * Math.random()));
            head.next = node;
            head = node;
        }
        return pre;
    }

    private static void printDoubleList(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }


}
