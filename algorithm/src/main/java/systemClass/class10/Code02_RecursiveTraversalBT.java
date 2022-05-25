package systemClass.class10;

/**
 * 二叉树的先序，中序，后序
 *
 * @author: thirteenmj
 * @date: 2022-05-24 19:47
 */
public class Code02_RecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {
        if (null == head) {
            return;
        }
        print(head);
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head) {
        if (null == head) {
            return;
        }
        in(head.left);
        print(head);
        in(head.right);
    }

    public static void post(Node head) {
        if (null == head) {
            return;
        }
        post(head.left);
        post(head.right);
        print(head);
    }

    private static void print(Node head) {
        if (null == head) {
            return;
        }
        System.out.print(head.value + " ");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        post(head);
        System.out.println("========");

    }
}
