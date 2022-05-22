package systemClass.class08;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author: thirteenmj
 * @date: 2022-05-21 22:41
 */
public class Code03_CountSort {

    public static void countSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] help = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxValue = 200;
        int maxLength = 10000;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);

            countSort(arr2);
            Arrays.sort(arr3);

            if (!isEquals(arr2, arr3)) {
                System.out.println("出错了！");
                System.out.println("原数组：");
                printArray(arr);
                System.out.println("排序结果：");
                printArray(arr2);
                System.out.println("对比结果：");
                printArray(arr3);
                return;
            }
        }
        System.out.println("success");
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
     * @param maxLength
     * @return
     */
    private static int[] generateRandomArray(int maxValue, int maxLength) {
        int size = (int) ((maxLength + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
}
