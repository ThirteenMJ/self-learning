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

        Node cur1 = head1;
        Node cur2 = head2;

        int n = 0;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }

        // 最后的节点不是同一个说明不相交
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);

        while (n > 0) {
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
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
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == head2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    /**
     * 获取单链表的环点
     *
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (null == fast.next || null == fast.next.next) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
        System.out.println("=====================================");
        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        System.out.println("=====================================");
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);
        System.out.println("=====================================");
        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
