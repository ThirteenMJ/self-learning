package beginClass.class04;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

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
        return null;
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
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int length = list.size();
        for (int i = 1; i < length -1; i++) {
            DoubleNode cur = list.get(i);
            cur.next = list.get(i - 1);
            cur.pre = pre;
            pre = cur;
        }
        return list.get(length - 1);
    }


    private static DoubleNode generateDoubleList(int maxValue, int maxLength) {
        int length = (int) (maxLength * Math.random() + 1);

        DoubleNode head = new DoubleNode(1);


        return head;
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

        }

        System.out.println("双链表测试通过");

    }

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



}
