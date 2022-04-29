package beginClass.class06;

/**
 * 二叉树的最大深度
 * 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree
 * 中文链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author: thirteenmj
 * @date: 2022-04-29 19:55
 */
public class Code04_MaximumDepthOfBinaryTree {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
