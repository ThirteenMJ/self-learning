package systemClass.class12;

/**
 * 判断一棵树是否是满二叉树
 * @author: thirteenmj
 * @date: 2022-09-21 20:10
 */
public class Code04_IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info2 {
        public boolean isFull;
        public int height;

        public Info2() {
        }

        public Info2(boolean isFull, int height) {
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isFull(Node head) {
        return process2(head).isFull;
    }

    public static Info2 process2(Node head) {
        if (null == head) {
            return new Info2(true, 0);
        }

        Info2 leftInfo = process2(head.left);
        Info2 rightInfo = process2(head.right);

        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info2(isFull, height);
    }

}
