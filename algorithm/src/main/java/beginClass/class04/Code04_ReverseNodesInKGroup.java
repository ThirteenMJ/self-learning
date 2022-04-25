package beginClass.class04;


/**
 * K个节点的组内逆序调整
 * 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 中文地址：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author: thirteenmj
 * @date: 2022-04-25 14:33
 */
public class Code04_ReverseNodesInKGroup {

    public static class ListNode {
        public ListNode next;
        public int value;

        public ListNode() {
            this.next = null;
            this.value = 0;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (null == end) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (null == end) {
                return head;
            }

            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (start != null && --k > 0) {
            start = start.next;
        }
        return start;
    }

    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

}
