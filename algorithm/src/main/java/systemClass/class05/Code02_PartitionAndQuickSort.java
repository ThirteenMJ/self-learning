package systemClass.class05;

import java.util.Arrays;

/**
 * 快排
 *
 * @author: thirteenmj
 * @date: 2022-05-17 20:22
 */
public class Code02_PartitionAndQuickSort {

    public static void quickSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition1(arr, left, right);
        process1(arr, left, mid - 1);
        process1(arr, mid + 1, right);
    }

    public static int partition1(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }

        int lessRight = left -1;
        int moreLeft = right;
        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[right]) {
                swap(arr, i, ++lessRight);
            }
        }
        swap(arr, ++lessRight, right);
        return lessRight;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int maxLength = 1000;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);

            Arrays.sort(arr2);
            quickSort1(arr3);

            if (!isEquals(arr2, arr3)) {
                System.out.println("出错了！");
                System.out.println("原数组：");
                printArray(arr);
                System.out.println("对照数组：");
                printArray(arr2);
                System.out.println("排序数组1：");
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
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
