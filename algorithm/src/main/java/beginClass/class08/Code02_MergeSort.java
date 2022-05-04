package beginClass.class08;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归并排序
 *
 * @author: thirteenmj
 * @date: 2022-04-27 20:54
 */
public class Code02_MergeSort {

    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * 递归方法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void sort1(int[] arr, int left, int right) {
        if (null == arr || arr.length < 2) {
            return;
        }

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        sort1(arr, left, mid);
        sort1(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 非递归方法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void sort2(int[] arr, int left, int right) {
        if (null == arr || arr.length < 2) {
            return;
        }

        if (left >= right) {
            return;
        }
        int n = right - left + 1;
        int step = 1;

        while (step < n) {
            int l = left;
            while (l < right) {
                int m = 0;
                int r = 0;
                if (right - l + 1> step) {
                    m = l + step - 1;
                } else {
                    break;
                }
                if (right - m >= step) {
                    r = m + step;
                } else {
                    r = right;
                }
                merge(arr, l, m, r);
                if (r == right) {
                    break;
                } else {
                    l = r + 1;
                }
            }
            if (step > (n >> 1)) {
                break;
            }
            step *= 2;
        }

    }


    /**
     * 合并左右两遍
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int[] ans = new int[right - left + 1];
        int index = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            ans[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            ans[index++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            ans[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < right - left + 1; i++) {
            arr[left + i] = ans[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxLength = 5;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr = getNewArray(maxLength, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            Arrays.sort(arr1);
            mergeSort(arr2);
            if (!isEquals(arr1, arr2)) {
                System.out.println("出错了");
                System.out.println("原数组：");
                printArray(arr);
                System.out.println("对照结果：");
                printArray(arr1);
                System.out.println("方法结果：");
                printArray(arr2);
                return;
            }
        }
        System.out.println("success");
    }

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

    private static int[] getNewArray(int maxLength, int maxValue) {
        int length = (int) ((maxLength * Math.random()) + 1);
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (((maxValue) * Math.random() + 1) - (maxValue) * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
