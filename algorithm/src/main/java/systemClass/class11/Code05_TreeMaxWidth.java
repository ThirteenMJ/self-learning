package systemClass.class11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
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

        // 当前你正在统计哪一层的宽度
        int curLevel = 1;
        // 当前层 curLevel 层的宽度
        int curLevelNodes = 0;
        int max = 0;

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> hashMap = new HashMap<>();
        hashMap.put(head, 1);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Integer curlNodeLevel = hashMap.get(cur);
            if (cur.left != null) {
                queue.add(cur.left);
                hashMap.put(cur, curlNodeLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                hashMap.put(cur.right, curlNodeLevel + 1);
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


    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) Math.random() * maxValue);
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

        }

        System.out.println("测试结束");
    }
}
