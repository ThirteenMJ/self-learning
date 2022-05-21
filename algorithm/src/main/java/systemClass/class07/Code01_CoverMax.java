package systemClass.class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: thirteenmj
 * @date: 2022-05-18 21:52
 */
public class Code01_CoverMax {

    /**
     * 测试方法
     *
     * @param lines
     * @return
     */
    public static int maxCover1(int[][] lines) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lines.length; i++) {
            min = Math.min(min, lines[i][0]);
            max = Math.max(max, lines[i][1]);
        }

        int curMax = 0;
        for (double i = min + 0.5; i < max; i++) {
            int cur = 0;
            for (int j = 0; j < lines.length; j++) {
                if (lines[j][0] < i && lines[j][1] > i) {
                    cur++;
                }
            }
            curMax = Math.max(cur, curMax);
        }
        return curMax;
    }

    public static int maxCover2(int[][] lines) {
        if (null == lines || lines.length < 1) {
            return 0;
        }
        Line[] newLines = new Line[lines.length];
        for (int i = 0; i < lines.length; i++) {
            newLines[i] = new Line(lines[i][0], lines[i][1]);
        }

        Arrays.sort(newLines, new MyComparator());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < newLines.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= newLines[i].start) {
                queue.poll();
            }
            queue.add(newLines[i].end);
            max = Math.max(max, queue.size());
        }

        return max;
    }

    public static class Line {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 与方法比较，没有创建一个类，而是使用 lambda 表达式的方法
     *
     * @param lines
     * @return
     */
    public static int maxCover3(int[][] lines) {
        if (null == lines || lines .length < 1) {
            return 0;
        }

        Arrays.sort(lines, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= lines[i][0]) {
                heap.poll();
            }
            heap.add(lines[i][1]);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static class MyComparator implements Comparator<Line> {

        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }

    public static void main(String[] args) {
        int testTime = 1000;
        int startIndex = 0;
        int maxRight = 200;
        int maxLength = 1000;
        for (int i = 0; i < testTime; i++) {
            int[][] lines = generateLines(maxLength, startIndex, maxRight);

            int testAns = maxCover1(lines);
            int myAns = maxCover2(lines);
            int testAns2 = maxCover3(lines);
            if (testAns != myAns || testAns != testAns2) {
                System.out.println("出错了！");
                System.out.println("testAns:" + testAns);
                System.out.println("myAns:" + myAns);
                System.out.println("testAns2:" + testAns2);
                return;
            }
        }
        System.out.println("success!");
    }

    /**
     * 随机生成一个数组
     *
     * @param maxLength
     * @param startIndex
     * @param maxRight
     * @return
     */
    private static int[][] generateLines(int maxLength, int startIndex, int maxRight) {
        int length = (int) ((maxLength + 1) * Math.random());
        int[][] arr = new int[length][2];
        for (int i = 0; i < length; i++) {
            int left = startIndex + (int) ((maxRight - startIndex + 1) * Math.random());
            int right = startIndex + (int) ((maxRight - startIndex + 1) * Math.random());
            if (left == right) {
                right++;
            }
            arr[i][0] = Math.min(left, right);
            arr[i][1] = Math.max(left, right);
        }

        return arr;
    }


}
