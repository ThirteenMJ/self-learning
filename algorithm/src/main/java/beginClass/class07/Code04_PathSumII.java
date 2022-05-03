package beginClass.class07;

import java.util.LinkedList;
import java.util.List;

/**
 * 求路径和等于指定数字的数组
 * 测试链接：https://leetcode.com/problems/path-sum-ii
 * 中文链接：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author: thirteenmj
 * @date: 2022-05-03 21:50
 */
public class Code04_PathSumII {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> ans = new LinkedList<>();
        List<List<Integer>> ansList = new LinkedList<>();
        if (null == root) {
            return ansList;
        }
        pathSum(root, ans, targetSum, 0, ansList);
        return ansList;
    }

    private static void pathSum(TreeNode root, List<Integer> ans, int targetSum, int preSum, List<List<Integer>> ansList) {
        if (null == root) {
            return;
        }

        if (null == root.left && null == root.right) {
            if (preSum + root.val == targetSum) {
                ans.add(root.val);
                ansList.add(copyList(ans));
                ans.remove(ans.size() - 1);
            }
            return;
        }
        preSum += root.val;
        ans.add(root.val);
        if (root.left != null) {
            pathSum(root.left, ans, targetSum, preSum, ansList);
        }
        if (root.right != null) {
            pathSum(root.right, ans, targetSum, preSum, ansList);
        }
        ans.remove(ans.size() - 1);
    }

    private static List<Integer> copyList(List<Integer> ans) {
        if (null == ans) {
            return null;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ans.size(); i++) {
            list.add(ans.get(i));
        }
        return list;
    }
}
