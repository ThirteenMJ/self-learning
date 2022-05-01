package beginClass.class06;

import sun.security.util.Length;

/**
 * 利用先序遍历和中序遍历创建一棵树
 * 测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 中文链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author: thirteenmj
 * @date: 2022-04-29 20:42
 */
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] pre, int left1, int right1, int[] in, int left2, int right2) {
        if (left1 > right1) {
            return null;
        }

        TreeNode head = new TreeNode(pre[left1]);

        if (left1 == right1) {
            return head;
        }

        int headIndex = find(pre[left1], in, left2, right2);


        head.left = build(pre, left1 + 1, left1 + headIndex - left2, in, left2, headIndex - 1);
        head.right = build(pre, left1 + headIndex - left2 + 1, right1, in, headIndex + 1, right2);
        return head;
    }

    private int find(int number, int[] in, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (number == in[i]) {
                return i;
            }
        }
        return -1;
    }


}
