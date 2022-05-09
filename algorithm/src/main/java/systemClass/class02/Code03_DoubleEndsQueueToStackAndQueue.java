package systemClass.class02;

/**
 * @author: thirteenmj
 * @date: 2022-05-06 22:17
 */
public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<V> {
        public Node next;
        public int val;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    public static class DoubleEndsQueue<V> {
        public Node<V> head;
        public Node<V> tail;

        public DoubleEndsQueue(Node<V> head, Node<V> tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
