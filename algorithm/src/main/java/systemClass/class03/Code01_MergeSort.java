package systemClass.class03;

import java.util.Arrays;

/**
 * 归并排序
 * 欠：非递归方法
 *
 * @author: thirteenmj
 * @date: 2022-05-12 14:29
 */
public class Code01_MergeSort {

    /**
     * 递归方法
     *
     * @param arr
     */
    public static void mergeSort1(int[] arr) {
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process1(arr, l, mid);
        process1(arr, mid + 1, r);
        merge1(arr, l, mid, r);
    }

    private static void merge1(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int leftIndex = l;
        int rightIndex = mid + 1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= r) {
            temp[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while (leftIndex <= mid) {
            temp[index++] = arr[leftIndex++];
        }

        while (rightIndex <= r) {
            temp[index++] = arr[rightIndex++];
        }

        for (int i = 0; i < r - l + 1; i++) {
            arr[l + i] = temp[i];
        }
    }

    /**
     * 非递归方法
     *
     * @param arr
     */
    public static void mergeSort2(int[] arr) {
        process1(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int step = 1;
        while (step < (r - l)) {
            if (step > ((r - l + 1) >> 1)) {
                break;
            }
        }
    }

    private static void merge2(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int leftIndex = l;
        int rightIndex = mid + 1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= r) {
            temp[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while (leftIndex <= mid) {
            temp[index++] = arr[leftIndex++];
        }

        while (rightIndex <= r) {
            temp[index++] = arr[rightIndex++];
        }

        for (int i = 0; i < r - l + 1; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int maxLength = 100;
        int maxValue = 10000;
        int testTime = 10000;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            mergeSort1(arr2);
            Arrays.sort(arr3);
            if (!isEquals(arr2, arr3)) {
                System.out.println("出错了");
                System.out.print("原数组：");
                printArray(arr);
                System.out.print("结果：");
                printArray(arr2);
                System.out.print("对照结果：");
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
    private static int[] generateRandomArray(int maxValue, int maxSize) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
