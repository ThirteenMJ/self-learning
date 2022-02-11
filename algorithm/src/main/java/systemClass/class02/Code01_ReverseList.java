package systemClass.class02;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

/**
 * 给一个链表，要求返回顺序倒过来的值
 *
 * @author: thirteenmj
 * @date: 2022-01-26 16:44
 */
public class Code01_ReverseList {

    /**
     * 单链表结构
     */
    public static class Node {

        public Node next;

        public int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {

            List<Integer> list = new ArrayList<>();
            Node temp = this;
            while (temp != null) {
                list.add(this.value);
                temp = temp.next;
            }

            return list.toString();
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxLength = 100;

        for (int i = 0; i < testTime; i++) {

            Node head = generateLinkedList(maxValue, maxLength);
            Node copy = copyLinkedList(head);
//            Node result1 = reverLinkedList(copy);
//            Node result2 = testReverLinkedList(result1);


//            Node result1 = verificationReverse(node);
//            Node result2 = reverse(node);
//
//            if (!isEquals()) {
//
//            }

        }

    }

    /**
     * 复制单链表结构
     *
     * @param head
     * @return
     */
    private static Node copyLinkedList(Node head) {
        Node copyHead = new Node(head.value);
        Node temp = copyHead;
        Node tempHead = head.next;
        while (tempHead != null) {
            Node node = new Node(temp.value);
            temp.next = node;
            temp = node;
            tempHead = tempHead.next;
        }

        return copyHead;
    }


    /**
     * 打印链表结构
     *
     * @param node
     */
    private static void printLikedList(Node node) {
        System.out.print("链表：");
        if (node != null) {
            Node temp = node;
            while (temp != null) {
                System.out.print(" " + temp.value);
                temp = temp.next;
            }
        }
        System.out.println();
    }

    /**
     * 生成一个单链表结构
     *
     * @param maxValue
     * @param maxLength
     * @return
     */
    private static Node generateLinkedList(int maxValue, int maxLength) {
        int length = (int) (maxLength * Math.random() + 1);

        Node head = null;
        Node temp = null;
        for (int i = 0; i < length; i++) {
            int value =  (int) ((maxValue * Math.random()) + 1) - (int) ( maxValue * Math.random());
            Node node = new Node(value);

            if (i == 0) {
                head = node;
            } else {
                temp.next = node;
            }

            temp = node;
        }
        return head;
    }

}
