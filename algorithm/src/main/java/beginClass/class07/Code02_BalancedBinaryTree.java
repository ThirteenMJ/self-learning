package beginClass.class07;

/**
 *
 *
 * 测试链接：https://leetcode.com/problems/balanced-binary-tree
 * 中文地址：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author: thirteenmj
 * @date: 2022-05-02 16:21
 */
public class Code02_BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Info {
        public boolean isBalanced;
        public int height;
        Info() {

        }
        Info(int height) {
            this.height = height;
        }
        Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return treeBalancedInfo(root).isBalanced;
    }

    public Info treeBalancedInfo(TreeNode root) {
        if (null == root) {
            return new Info(0, true);
        }

        Info leftInfo = treeBalancedInfo(root.left);
        Info rightInfo = treeBalancedInfo(root.right);

        boolean isBalanced = leftInfo.isBalanced
                && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(height, isBalanced);
    }
}
