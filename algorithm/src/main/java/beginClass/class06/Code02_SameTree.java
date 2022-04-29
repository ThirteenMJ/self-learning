package beginClass.class06;

/**
 * 测试链接：https://leetcode.com/problems/same-tree
 * 中文地址：
 *
 * @author: thirteenmj
 * @date: 2022-04-29 19:12
 */
public class Code02_SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
            if (null == p ^ null == q) {
                return false;
            }
            if (null == p && null == q) {
                return true;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
