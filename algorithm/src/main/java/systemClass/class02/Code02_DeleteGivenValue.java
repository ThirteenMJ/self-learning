package systemClass.class02;

/**
 * 将单链表中指定的值删除
 * 测试链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author: thirteenmj
 * @date: 2022-05-06 21:16
 */
public class Code02_DeleteGivenValue {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
