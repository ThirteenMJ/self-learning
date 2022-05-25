package systemClass.class09;


import java.util.HashMap;

/**
 * 测试链接：https://leetcode.com/problems/copy-list-with-random-pointer/
 * 中文链接：https://leetcode.cn/problems/copy-list-with-random-pointer/
 *
 * @author: thirteenmj
 * @date: 2022-05-23 19:56
 */
public class Code04_CopyListWithRandom {

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int value) {
            this.val = value;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        HashMap<Node, Node> hashMap = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            hashMap.put(cur, node);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            if (null != cur.next && hashMap.containsKey(cur.next)) {
                hashMap.get(cur).next = hashMap.get(cur.next);
            }
            if (null != cur.random && hashMap.containsKey(cur.random)) {
                hashMap.get(cur).random = hashMap.get(cur.random);
            }
            cur = cur.next;
        }

        return hashMap.get(head);
    }

    public static Node copyRandomList2(Node head) {
        if (null == head) {
            return null;
        }

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node newHead = head.next;
        while (cur != null) {
            Node newNext = cur.next;
            next = cur.next.next;
            cur.next = next;
            newNext.next = next != null ? next.next : null;
            cur = next;
        }
        return newHead;
    }
}
