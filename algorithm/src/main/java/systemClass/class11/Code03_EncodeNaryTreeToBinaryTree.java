package systemClass.class11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: thirteenmj
 * @date: 2022-08-24 19:38
 */
public class Code03_EncodeNaryTreeToBinaryTree {

    public static class Node {
        int val;
        List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Codec {
        public TreeNode encode(Node root) {
            TreeNode head = new TreeNode(root.val);
            head.left = en(root.children);
            return head;
        }

        private TreeNode en(List<Node> children) {
            if (null == children || children.size() == 0) {
                return null;
            }
            TreeNode head = null;
            TreeNode cur = null;

            for (Node child : children) {
                TreeNode treeNode = new TreeNode(child.val);
                if (null == head) {
                    head = treeNode;
                } else {
                    cur.right = treeNode;
                }
                cur = treeNode;
                cur.left = en(child.children);
            }
            return head;
        }

        public Node decode(TreeNode root) {
            if (null == root) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        private List<Node> de(TreeNode root) {
            List<Node> children = new ArrayList<>();
            if (root != null) {
                Node node = new Node(root.val, de(root.left));
                children.add(node);
                root = root.right;
            }
            return  children;
        }
    }
}
