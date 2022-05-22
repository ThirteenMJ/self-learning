package systemClass.class08;

import java.util.Arrays;

/**
 * 基数排序
 * 适用于非负数
 *
 * @author: thirteenmj
 * @date: 2022-05-22 14:37
 */
public class Code04_RadixSort {

    public static void radixSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        radixSort(arr, 0, arr.length -1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int left, int right, int digit) {
        int[] help = new int[right -left + 1];
        for (int i = 0; i < digit; i++) {
            int[] count = new int[10];
            for (int j = left; j <= right; j++) {
                int remainder = getDigit(arr[j], i);
                count[remainder]++;
            }
            for (int j = 1; j < 10; j++) {
                count[j] = count[j] + count[j - 1];
            }
            for (int j = right; j >= left; j--) {
                int remainder = getDigit(arr[j], i);
                help[--count[remainder]] = arr[j];
            }
            for (int j = 0; j < (right - left + 1); j++) {
                arr[left + j] = help[j];
            }
        }
    }

    private static int getDigit(int number, int digits) {
        return (number / (int) (Math.pow(10, digits))) % 10;
    }

    /**
     * 获取数组中最大值的位数
     *
     * @param arr
     */
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int res = 0;
        while (max > 0) {
            max /= 10;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int maxValue = 1000;
        int maxLength = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            radixSort(arr2);
            Arrays.sort(arr3);
            if (!isEquals(arr2, arr3)) {
                System.out.println("出错了！");
                System.out.println("原数组");
                printArray(arr);
                System.out.println("myAns:");
                printArray(arr2);
                System.out.println("testAns:");
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
     * @param maxSize
     * @return
     */
    private static int[] generateRandomArray(int maxValue, int maxSize) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
}
