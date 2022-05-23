package systemClass.class09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: thirteenmj
 * @date: 2022-05-22 17:07
 */
public class Code01_LinkedListMid {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 寻找中节点或者中上节点
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null &&  fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找中节点或者中下节点
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidNode(Node head) {
        if (null == head || null == head.next ) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null &&  fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找中节点或者中上节点的前一个节点
     *
     * @param head
     * @return
     */
    public static Node midOrUpMidPreNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        // 我自己的写法
//        Node slow = head;
//        Node fast = head;
//        Node lastSlow = null;
//        while (fast.next != null &&  fast.next.next != null) {
//            lastSlow = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return lastSlow;
        // 左老师的写法
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null &&  fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找中节点或者中下节点的前一个节点
     *
     * @param head
     * @return
     */
    public static Node midOrDownMidPreNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null &&  fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找中节点或者中上节点的对照方法
     * @param head
     * @return
     */
    public static Node right1(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node node = head;
        List<Node> nodeList = new ArrayList<>();
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        int length = nodeList.size();
        int index = (length - 1) / 2;

        return nodeList.get(index);
    }

    /**
     * 寻找中节点或者中下节点的对照方法
     *
     * @param head
     * @return
     */
    public static Node right2(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node node = head;
        List<Node> nodeList = new ArrayList<>();
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        int length = nodeList.size();
        int index = length / 2;

        return nodeList.get(index);
    }

    /**
     * 寻找中节点或者中上节点的前一个节点的对照方法
     *
     * @param head
     * @return
     */
    public static Node right3(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node node = head;
        List<Node> nodeList = new ArrayList<>();
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        int length = nodeList.size();
        int index = (length - 3) / 2;

        return nodeList.get(index);
    }

    /**
     * 寻找中节点或者中上节点的前一个节点
     *
     * @param head
     * @return
     */
    public static Node right4(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node node = head;
        List<Node> nodeList = new ArrayList<>();
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        return nodeList.get((nodeList.size() - 2) / 2);
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);

        Node ans1 = null;
        Node ans2 = null;

        ans1 = midOrUpMidNode(test);
        ans2 = right1(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");
        System.out.println("==============================");

        ans1 = midOrDownMidNode(test);
        ans2 = right2(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");
        System.out.println("==============================");

        ans1 = midOrUpMidPreNode(test);
        ans2 = right3(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");
        System.out.println("==============================");

        ans1 = midOrDownMidPreNode(test);
//        ans2 = right4(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");
    }
}
