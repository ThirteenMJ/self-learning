package systemClass.class13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否是完全二叉树
 * @author: thirteenmj
 * @date: 2022-09-23 14:38
 */
public class Code01_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT1(Node head) {
        if (null == head) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            left = node.left;
            right = node.right;
            if ((leaf && (left != null || right != null))
                    || (null == left && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (null == left || null == right) {
                leaf = true;
            }
        }
        return true;
    }

    public static class Info {
        boolean isFull;
        boolean isCBT;
        int height;

        public Info() {
        }

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    public static boolean isCBT2(Node head) {
        return process(head).isCBT;
    }

    private static Info process(Node head) {
        if (null == head) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        boolean isCBT = false;

        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isCBT = true;
        } else if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height){
            isCBT = true;
        }

        return new Info(isFull, isCBT, height);
    }

    public static Node generateRandomTree(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }

        Node node = new Node((int) (Math.random() * maxValue));
        node.left = generate(level + 1, maxLevel, maxValue);
        node.right = generate(level + 1, maxLevel, maxValue);

        return node;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 10;
        int testTime = 10000;

        for (int i = 0; i < testTime; i++) {
            Node head = generateRandomTree(maxLevel, maxValue);
            boolean ans1 = isCBT1(head);
            boolean ans2 = isCBT2(head);
            if (ans1 != ans2) {
                System.out.println(String.format("出错了，ans1:%s,ans2:%s", ans1, ans2));
                return;
            }
        }
        System.out.println("测试结束");
    }
}
