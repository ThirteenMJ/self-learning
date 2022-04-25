package beginClass.class04;


/**
 * 两个单链表相加
 * 测试链接：https://leetcode.com/problems/add-two-numbers/
 * 中文版链接：https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author: thirteenmj
 * @date: 2022-04-25 17:18
 */
public class Code05_AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
            this.val = 0;
            this.next = null;
        }
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        ListNode l = length1 >= length2 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;
        ListNode curl = l;
        ListNode curs = s;
        ListNode last = l1;
        int more = 0;
        while (curs != null) {
            int total = curl.val + curs.val + more;
            more = total / 10;
            curl.val = total % 10;
            last = curl;
            curl = curl.next;
            curs = curs.next;
        }

        while (curl != null) {
            int total = curl.val + more;
            more = total / 10;
            curl.val = total % 10;
            last = curl;
            curl = curl.next;
        }

        if (more != 0) {
            ListNode node = new ListNode(more);
            last.next = node;
        }

        return l;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,4,9};
        int[] arr2 = {5,6,4,9};
        ListNode node1 = getLinkedNode(arr1);
        printLinkedNode(node1);
        ListNode node2 = getLinkedNode(arr2);
        printLinkedNode(node2);
        ListNode result = addTwoNumbers(node1, node2);
        printLinkedNode(result);
    }

    private static ListNode getLinkedNode(int[] arr) {
        while (null == arr || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode start = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            start.next = node;
            start = start.next;
        }
        return head;
    }

    private  static void  printLinkedNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
