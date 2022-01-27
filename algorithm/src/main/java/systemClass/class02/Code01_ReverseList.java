package systemClass.class02;

/**
 * 给一个链表，要求返回顺序倒过来的值
 *
 * @author: thirteenmj
 * @date: 2022-01-26 16:44
 */
public class Code01_ReverseList {

    public class Node {

        public Node next;

        public int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxLength = 100;

        for (int i = 0; i < testTime; i++) {

//            Node node = generateSingleLinkedList(maxValue, maxLength);
//
//            Node result1 = verificationReverse(node);
//            Node result2 = reverse(node);
//
//            if (!isEquals()) {
//
//            }

        }

    }

}
