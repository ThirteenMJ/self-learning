package systemClass.class13;

/**
 * 返回 a 和 b 的最低祖先
 * @author: thirteenmj
 * @date: 2022-09-23 16:13
 */
public class Code03_lowestAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        boolean findA;
        boolean findB;
        Node ans;

        public Info() {
        }

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static Node lowestAncestor2(Node head, Node a, Node b) {
        return process(head, a, b).ans;
    }

    private static Info process(Node head, Node a, Node b) {
        if (null == head) {
            return new Info(false, false, null);
        }

        Info leftInfo = process(head.left, a, b);
        Info rightInfo = process(head.right, a, b);

        boolean findA = leftInfo.findA || rightInfo.findA || (head == a);
        boolean findB = leftInfo.findB || rightInfo.findB || (head == b);
        Node ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findA && findB ) {
                ans = head;
            }
        }
        return new Info(findA, findB, ans);
    }
}
