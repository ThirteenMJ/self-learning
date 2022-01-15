package systemClass.class01;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: thirteenmj
 * @date: 2022-01-15 15:45
 */
public class Code03_InsertionSort {

    public static void insertionSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i -1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        // 测试次数
        int testTime = 500000;
        // 随机数组长度 0-100
        int maxSize = 100;
        // 值 -100～100
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArr(arr);
                printArr(arr1);
                printArr(arr2);
                break;
            }
        }
            System.out.println(succeed ? "Nice" : "Fucking fucked");


    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * 比较两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2 != null) {
            return false;
        }

        if (arr1 != null && arr2 == null) {
            return false;
        }

        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        if (arr1.length == 0 && arr2.length == 0) {
            return true;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用自带的方法进行排序
     *
     * @param arr2
     */
    private static void comparator(int[] arr2) {
        Arrays.sort(arr2);
    }

    /**
     * 复制一个数组
     *
     * @param arr1
     * @return
     */
    private static int[] copyArray(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        return arr2;
    }

    /**
     * 创建一个数组
     * Math.random() -> [0,1) 的所有小数，等概率的返回一个
     * Math.random() * N -> [0,N) 的所有小数，等概率的返回一个
     * (int) Math.random() * N -> [0, N - 1] 的所有整数，等概率返回一个
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxSize + 1) * Math.random()) - (int)(maxSize * Math.random());
        }
        return arr;
    }

}
