package systemClass.class12;

/**
 * 找到子树中最大的搜索二叉树的大小
 * @author: thirteenmj
 * @date: 2022-09-22 21:33
 */
public class Code05_MaxSubBSTSize {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        int maxBSTSubtreeSize;
        int max;
        int min;
        int allSize;

        public Info() {
        }

        public Info(int maxSubBST, int max, int min, int allSize) {
            this.maxBSTSubtreeSize = maxSubBST;
            this.max = max;
            this.min = min;
            this.allSize = allSize;
        }
    }

    public static int maxSubBSTSize2(Node head) {
        if (null == head) {
            return 0;
        }
        return process(head).maxBSTSubtreeSize;
    }

    private static Info process(Node head) {
        if (null == head) {
            return null;
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int max = head.value;
        int min = head.value;
        int allSize = 1;

        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            allSize += leftInfo.allSize;
        }

        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            allSize += rightInfo.allSize;
        }

        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxBSTSubtreeSize;
        }
        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxBSTSubtreeSize;
        }
        int p3 = -1;
        boolean leftIsBST = leftInfo == null ? true : (leftInfo.maxBSTSubtreeSize == leftInfo.allSize);
        boolean rightIsBST = rightInfo == null ? true : (rightInfo.maxBSTSubtreeSize == rightInfo.allSize);

        if (leftIsBST && rightIsBST) {
            boolean leftMaxLessHead = leftInfo == null ? true : leftInfo.max < head.value;
            boolean rightMinMoreHead = rightInfo == null ? true : rightInfo.min > head.value;

            if (leftMaxLessHead && rightMinMoreHead) {
                int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }

        int maxSubBST = Math.max(Math.max(p1, p2), p3);


        return new Info(maxSubBST, max, min, allSize);
    }
}
