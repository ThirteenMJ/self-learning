package beginClass.class04;

/**
 * 合并两个有序单链表
 * 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 * 中文链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author: thirteenmj
 * @date: 2022-04-25 19:32
 */
public class Code06_MergeTwoSortedLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
            this.val = 0;
            this.next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1 || null == list2) {
            return null == list1 ? list2 : list1;
        }

        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == list2 ? list1 : list2;
        ListNode start = head;
        while (cur1 != null && cur2 != null) {
            if (cur2.val <= cur1.val) {
                start.next = cur2;
                cur2 = cur2.next;
            } else {
                start.next = cur1;
                cur1 = cur1.next;
            }
            start = start.next;
        }
        start.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
