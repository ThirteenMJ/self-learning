package systemClass.class10;

/**
 * 找到两个单链表第一次相交的节点
 *
 * @author: thirteenmj
 * @date: 2022-05-23 20:59
 */
public class Code01_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }

        // 获取两个单链表之间的环点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head1);

        if (null == loop1 && null == loop2) {
            return noLoop(head1, head2);
        }

        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        // 如果其中一个没有环点，而另一个环点有环点，肯定是不相交的
        return null;
    }

    /**
     * 判断两个无环的单链表是否相交
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        int length1 = 1;
        int length2 = 1;

        Node cur1 = head1;
        Node cur2 = head2;

        while (cur1.next != null){
            length1++;
            cur1 = cur1.next;
        }

        while (cur2.next != null){
            length2++;
            cur2 = cur2.next;
        }

        // 最后的节点不是同一个说明不相交
        if (cur1 != cur2) {
            return null;
        }

        int ans = length1 - length2;

        while (ans < 0) {
            ans++;
            head2 = head2.next;
        }

        while (ans > 0) {
            ans--;
            head1 = head1.next;
        }

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }

    /**
     * 判断两个有环单链表是否相交
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        if (loop1 != loop2) {
            return null;
        }
        return null;
    }

    /**
     * 获取单链表的环点
     *
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        if (null == head) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
