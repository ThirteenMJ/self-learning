package systemClass.class12;

/**
 * 求二叉树中任意两个节点相距的最大距离
 * @author: thirteenmj
 * @date: 2022-09-21 19:53
 */
public class Code06_MaxDistance {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static Info process(Node head) {
        if (null == head) {
            return new Info(0, 0);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(p1, p2), p3) ;
        return new Info(maxDistance, height);
    }
}
