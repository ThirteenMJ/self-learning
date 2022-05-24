package systemClass.class09;

import java.util.ArrayList;
import java.util.List;

/**
 * 将某单链表划分成左边小，中间相等，右边大的形式
 *
 * @author: thirteenmj
 * @date: 2022-05-23 19:53
 */
public class Code03_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (null == head) {
            return null;
        }

        ArrayList<Node> nodeArrayList = new ArrayList<>();

        while (head != null) {
            nodeArrayList.add(head);
            head = head.next;
        }

        arrPartition(nodeArrayList, pivot);

        for (int i = 1; i < nodeArrayList.size(); i++) {
            nodeArrayList.get(i - 1).next = nodeArrayList.get(i);
        }
        nodeArrayList.get(nodeArrayList.size() - 1).next = null;
        return nodeArrayList.get(0);
    }

    private static void arrPartition(List<Node> nodeList, int pivot) {
        if (null == nodeList) {
            return;
        }

        int smallRight = -1;
        int moreLeft = nodeList.size();
        int index = 0;
        while (index < moreLeft) {
            if (nodeList.get(index).value < pivot) {
                swap(nodeList, index++, ++smallRight);
            } else if (nodeList.get(index).value > pivot) {
                swap(nodeList, index++, --moreLeft);
            } else {
                index++;
            }
        }
    }

    private static void swap(List<Node> nodeList, int index, int target) {
        Node indexNode = nodeList.get(index);
        Node targetNode = nodeList.get(target);
        nodeList.set(index, targetNode);
        nodeList.set(target, indexNode);
    }

    public static Node listPartition2(Node head, int pivot) {
        if (null == head) {
            return null;
        }
        Node smallHead = null;
        Node smallTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node moreHead = null;
        Node moreTail = null;

        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            } else if (head.value == pivot){
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }
            head = next;
        }

        if (smallHead != null) {
            // 我的写法
            smallTail.next = equalHead != null ? equalHead : moreHead;
            // 老师的写法
//            smallTail.next = equalHead;
//            equalTail = equalTail == null ? smallTail : equalTail;
        }

        if (equalHead != null) {
            equalTail.next = moreHead;
        }

        return smallHead != null ? smallHead : (equalHead != null ? equalHead : moreHead);
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//        head1 = listPartition1(head1, 5);
//        printLinkedList(head1);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
