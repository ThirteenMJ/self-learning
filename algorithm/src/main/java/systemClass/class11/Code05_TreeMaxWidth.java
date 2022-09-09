package systemClass.class11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输出二叉树最大宽度
 * @author: thirteenmj
 * @date: 2022-08-25 20:07
 */
public class Code05_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (null == head) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // key 在哪一层，value
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        // 当前你正在统计哪一层的宽度
        int curLevel = 1;
        // 当前层 curLevel 层的宽度
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curlNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                queue.add(cur.left);
                levelMap.put(cur.left, curlNodeLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                levelMap.put(cur.right, curlNodeLevel + 1);
            }

            if (curlNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWithNoMap(Node head) {
        if (null == head) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // 当前层，最右节点是谁
        Node curEnd = head;
        // 下层，最右节点是谁
        Node nextEnd = null;
        int max = 0;
        // 当前层的节点数
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }


    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.3) {
            return null;
        }
        int value = (int) (Math.random() * maxValue);
        Node head = new Node(value);
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTime = 10000;

        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            Node node = generateRandomBST(maxLevel, maxValue);
            if (maxWithNoMap(node) != maxWidthUseMap(node)) {
                System.out.println("出错了:withMap:" + maxWidthUseMap(node) + ",withNoMap:" + maxWithNoMap(node));
                break;
            }
        }

        System.out.println("测试结束");
    }
}
