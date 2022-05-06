package systemClass.class01;

import java.util.Arrays;

/**
 * @author: thirteenmj
 * @date: 2022-01-20 21:34
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr == null) {
            return;
        }
        if (i == j) {
            return;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int testTime = 50000;
        int maxLength = 100;
        int maxValue = 100;

        for (int i = 0; i < testTime; i++) {

            int[] arr = generationArray(maxLength, maxValue);
            int[] arr1 = copyArray(arr);

            Arrays.sort(arr);
            bubbleSort(arr1);

            if (!isEquals(arr, arr1)) {
                printArray(arr);
                printArray(arr1);
                System.out.println("算法错误");
                return;
            }
        }
        System.out.println("算法正确");
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
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
    private static int[] generationArray(int maxValue, int maxSize) {
        int size = (int) (maxSize * Math.random()) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (maxValue * Math.random()) + 1;
        }
        return arr;
    }

}
