package systemClass.class06;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给一个无序数组，但是这个无序数组保证，进行排序后，每一个数移动的位置不超过 k 个
 *
 * @author: thirteenmj
 * @date: 2022-05-18 15:33
 */
public class Code04_SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        if (k == 0) {
            return;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;
        while (index < Math.min(arr.length, k)) {
            queue.add(arr[index++]);
        }

        int i = 0;
        while (index < arr.length) {
            queue.add(arr[index++]);
            arr[i++] = queue.poll();
        }

        while (!queue.isEmpty()) {
            arr[i++] = queue.poll();
        }

    }

    public static void main(String[] args) {
        int maxValue = 10;
        int maxLength = 10;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxLength);
            int[] arr = generateRandomArray(maxValue, maxLength, k);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            sortedArrDistanceLessK(arr2, k);
            Arrays.sort(arr3);
            if (!isEquals(arr2, arr3)) {
                System.out.println("出错了！");
                System.out.println("原数组：");
                printArray(arr);
                System.out.println("结果：");
                printArray(arr2);
                System.out.println("对照结果：");
                printArray(arr3);
                return;
            }
        }
        System.out.println("success!");
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 比较两个数组的内容是否相同
     *
     * @param arr
     * @param arr1
     * @return
     */
    private static boolean isEquals(int[] arr, int[] arr1) {

        if (arr == null && arr1 != null) {
            return false;
        }
        if (arr != null && arr1 == null) {
            return false;
        }
        if (arr == null && arr1 == null) {
            return true;
        }

        if (arr.length != arr1.length) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 复制数组
     *
     * @param arr
     * @return
     */
    private static int[] copyArray(int[] arr) {

        if (arr == null) {
            return null;
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 随机生成一个数组
     *
     * @param maxValue
     * @param maxSize
     * @return
     */
    private static int[] generateRandomArray(int maxValue, int maxSize, int k) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        Arrays.sort(arr);
        boolean[] help = new boolean[size];
        for (int i = 0; i < size; i++) {
            int targetIndex = Math.min(i + (int) (Math.random() * (k + 1)), arr.length - 1);
            if (!help[targetIndex] && !help[i]) {
                swap(arr, i, targetIndex);
                help[i] = true;
                help[targetIndex] = true;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int index, int target) {
        int temp = arr[index];
        arr[index] = arr[target];
        arr[target] = temp;
    }
}
