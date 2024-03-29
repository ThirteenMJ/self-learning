package systemClass.class02;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

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

        Node previous = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
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
            Node copy = copyLinkedList(head);
            Node result1 = revertLinkedList(copy);
            Node result2 = testRevertLinkedList(result1);
            if (!isEqualsForLinkedList(head, result2)) {
                System.out.println("垃圾");
                System.out.print("原单链条：");
                printLikedList(head);
                System.out.println("现单链条:");
                printLikedList(result2);
                return;
            }

            System.out.println("单链条测试通过");
        }

        for (int i = 0; i < testTime; i++) {

        }

    }

    private static boolean isEqualsForLinkedList(Node firstNode, Node secondNode) {
        Node temp1 = firstNode;
        Node temp2 = secondNode;

        if (firstNode == null && secondNode != null) {
            return false;
        }

        if (firstNode != null && secondNode == null) {
            return false;
        }

        while (temp1 != null && temp2 != null) {
            if (temp1.value != temp2.value) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (firstNode == null && secondNode != null) {
            return false;
        }

        if (firstNode != null && secondNode == null) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param head
     * @return
     */
    private static Node testRevertLinkedList(Node head) {

        Node newHead = new Node(head.value);
        head = head.next;
        Node temp = newHead;
        while (head != null) {
            Node node = new Node(head.value);
            node.next = temp;
            temp = node;
            head = head.next;
        }

        return temp;
    }

    /**
     * 复制单链表结构
     *
     * @param head
     * @return
     */
    private static Node copyLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(head.value);
        Node temp = newHead;
        head = head.next;

        while (head != null) {
            Node node = new Node(head.value);
            temp.next = node;
            temp = temp.next;
            head = head.next;
        }

        return newHead;
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

        Node head = null;
        Node temp = null;
        for (int i = 0; i < length; i++) {
            int value =  (int) ((maxValue * Math.random()) + 1) - (int) ( maxValue * Math.random());
            Node node = new Node(value);

            if (i == 0) {
                head = node;
            } else {
                temp.next = node;
            }

            temp = node;
        }
        return head;
    }



}
