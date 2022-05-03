package beginClass.class07;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断二叉树中是否有路径和等于指定的数字
 * 测试链接：https://leetcode.com/problems/path-sum
 * 中文链接：https://leetcode-cn.com/problems/path-sum/
 *
 * @author: thirteenmj
 * @date: 2022-05-03 20:22
 */
public class Code03_PathSum {

    public static class TreeNode {
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

    public static boolean isHave = false;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        isHave = false;
        if (null == root) {
            return isHave;
        }
        pathSum(root, targetSum, 0);
        return isHave;
    }

    private static void pathSum(TreeNode root, int targetSum, int preSum) {
        if (null == root) {
            return;
        }

        if (null == root.left && null == root.right) {
            if (preSum + root.val == targetSum) {
                isHave = true;
            }
            return;
        }
        preSum += root.val;
        if (root.left != null) {
            pathSum(root.left, targetSum, preSum);
        }
        if (root.right != null) {
            pathSum(root.right, targetSum, preSum);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        head.left = node1;
        head.right = node2;

        node1.left = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node8;

        System.out.println(hasPathSum(head, 22));


//        TreeNode head = new TreeNode(-2);
//        TreeNode node1 = new TreeNode(-3);
//
//        head.right = node1;

//        System.out.println(hasPathSum(head, -5));



    }
}
