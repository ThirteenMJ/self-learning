package systemClass.class14;

import java.util.PriorityQueue;

/**
 * 切割大金条，每次切割时会记录金条的长度，就将金条切割好之后，记录的金条长度最小
 * @author: thirteenmj
 * @date: 2022-10-08 23:50
 */
public class Code02_LessMoneySplitGold {

    /**
     * 暴力方法
     * @param arr
     * @return
     */
    public static int lessMoney1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }

        return process(arr, 0);
    }

    private static int process(int[] arr, int pre) {
        if (arr.length == 1) {
            return pre;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
            }
        }

        return ans;
    }

    private static int[] copyAndMergeTwo(int[] arr, int i, int j) {
        int[] ans = new int[arr.length - 1];
        int ansi = 0;
        for (int arri = 0; arri < arr.length; arri++) {
            if (arri != i && arri != j) {
                ans[ansi++] = arr[arri];
            }
        }
        ans[ansi] = arr[i] + arr[j];

        return ans;
    }

    /**
     * 贪心算法
     * @param arr
     * @return
     */
    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }

        int cur = 0;
        int sum = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
