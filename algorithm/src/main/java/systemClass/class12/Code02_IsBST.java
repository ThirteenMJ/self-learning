package systemClass.class12;

/**
 * 判断二叉树是否是搜索二叉树
 * @author: thirteenmj
 * @date: 2022-09-20 15:49
 */
public class Code02_IsBST {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        boolean isBST;
        int max;
        int min;

        public Info() {
        }

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isBST2(Node head) {
        if (null == head) {
            return true;
        }
        return process(head).isBST;
    }

    private static Info process(Node head) {
        if (null == head) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int max = head.value;
        int min = head.value;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (leftInfo.max >= head.value) {
            isBST = false;
        }
        if (rightInfo.min <= head.value) {
            isBST = false;
        }

        return new Info(isBST, max, min);
    }
}
