package beginClass.class03;

import java.util.Arrays;

/**
 * 局部最小位置
 * 无序
 * 相邻的数不相等
 *
 * @author: thirteenmj
 * @date: 2022-04-22 21:07
 */
public class Class04_BSAwesome {

    /**
     * 找局部最小值
     *
     * @param arr
     * @return
     */
    public static int oneMinIndex(int[] arr) {
        if (null == arr || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;

        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[right - 1] > arr[right]) {
            return right;
        }

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid -1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    right = mid - 1;
                } else  {
                    left = mid + 1;
                }
            }
        }

        return arr[left] < arr[right] ? left : right;
    }

    public static void main(String[] args) {
        int maxLength = 10;
        int maxValue = 100;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxLength, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                System.out.println("出错了");
                printArr(arr);
                System.out.println("index:" + ans);
                return;
            }
        }
        System.out.println("success");
    }

    public static boolean check(int[] arr, int index) {
        if (null == arr || arr.length == 0) {
            return index == -1;
        }
        if (arr.length == 1) {
            return index == 0;
        }

        int length = arr.length - 1;

        if (index == 0) {
            return arr[0] < arr[1];
        }

        if (index == length) {
            return arr[length - 1] > arr[length];
        }

        return (arr[index - 1] > arr[index] && arr[index] < arr[index + 1]);
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
     * 创建一个数组，相邻两个互不相等的无序数组
     *
     * @param maxLength
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxLength, int maxValue) {
        int length = (int) ((maxLength) * Math.random());
        int[] arr = new int[length];
        if (length > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < length; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }
}
