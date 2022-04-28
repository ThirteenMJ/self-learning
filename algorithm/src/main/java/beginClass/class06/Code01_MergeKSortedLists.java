package beginClass.class06;

import java.lang.annotation.Target;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
 * 中文链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author: thirteenmj
 * @date: 2022-04-27 20:55
 */
public class Code01_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class MyComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new MyComparator());
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = queue.peek();
        ListNode start = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
            }
            if (start == null) {
                start = node;
            } else {
                start.next = node;
                start = start.next;
            }
        }

        return head;

    }
}
