package systemClass.class10;

import java.util.Stack;

/**
 * 非递归实现先序、中序、后序遍历
 * 欠：后序遍历的一个栈实现方法
 *
 * @author: thirteenmj
 * @date: 2022-06-06 23:42
 */
public class Code03_UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {
        System.out.print("pre-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);

            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop.value + " ");
                if (pop.right != null) {
                    stack.add(pop.right);
                }
                if (pop.left != null) {
                    stack.add(pop.left);
                }
            }
        }
        System.out.println();
    }

    public static void in(Node head) {
        System.out.print("in-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.add(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void post1(Node head) {
        System.out.print("post1-order:");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.add(head);
            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                stack2.add(node);
                if (node.left != null) {
                    stack1.add(node.left);
                }
                if (node.right != null) {
                    stack1.add(node.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void post2(Node head) {
        System.out.print("post2-order:");
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        Node c = null;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && head != c.left && head != c.right) {
                stack.add(c.left);
            } else if (c.right != null && head != c.right) {
                stack.add(c.right);
            } else {
                System.out.print(stack.pop().value + " ");
                head = c;
            }
        }
        System.out.println();
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
        post1(head);
        System.out.println("========");
        post2(head);
        System.out.println("========");
    }
}
