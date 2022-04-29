package beginClass.class06;

/**
 * 测试链接：https://leetcode.com/problems/symmetric-tree
 * 中文链接：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author: thirteenmj
 * @date: 2022-04-29 19:23
 */
public class Code03_SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode h1, TreeNode h2) {
        if (null == h1 ^ null == h2) {
            return false;
        }
        if (null == h1 && null == h2) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }
}
