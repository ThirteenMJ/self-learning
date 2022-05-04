package beginClass.class07;

/**
 * 判断是否是二叉搜索树
 *
 * @author: thirteenmj
 * @date: 2022-05-03 22:05
 */
public class Code05_IsBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBst;
        public int min;
        public int max;

        public Info() {
        }

        public Info(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isBst(TreeNode root) {
        if (null == root) {
            return false;
        }
        return process(root).isBst;
    }

    /**
     * 默认是 true 的时候
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        if (null == root) {
            return null;
        }

        int min = root.val;
        int max = root.val;

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.min(leftInfo.max, max);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
        }

        boolean isBst = true;
        if (leftInfo != null && !leftInfo.isBst) {
            isBst = false;
        }
        if (rightInfo != null && !rightInfo.isBst) {
            isBst = false;
        }
        boolean leftMaxLessRoot = leftInfo == null ? true : (leftInfo.max < root.val);
        boolean rightMinMoreRoot = rightInfo == null ? true : (rightInfo.min > root.val);
        if (!(leftMaxLessRoot && rightMinMoreRoot)) {
            isBst = false;
        }

        return  new Info(isBst, min, max);
    }

    /**
     * 默认是 false 的时候
     *
     * @param root
     * @return
     */
    public static Info process2(TreeNode root) {
        if (null == root) {
            return null;
        }

        int min = root.val;
        int max = root.val;

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.min(leftInfo.max, max);
        }
        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.max(rightInfo.max, max);
        }

        boolean isBst = false;
        boolean leftIsBst = leftInfo == null ? true : leftInfo.isBst;
        boolean rightIsBst = rightInfo == null ? true : rightInfo.isBst;
        boolean leftMaxLessRoot = leftInfo == null ? true : (leftInfo.max < root.val);
        boolean rightMinMoreRoot = rightInfo == null ? true : (rightInfo.min > root.val);
       if (leftIsBst && rightIsBst && leftMaxLessRoot && rightMinMoreRoot) {
           isBst = true;
        }

        return  new Info(isBst, min, max);
    }
}
