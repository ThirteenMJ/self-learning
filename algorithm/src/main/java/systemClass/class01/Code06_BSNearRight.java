package systemClass.class01;

import java.util.Arrays;

/**
 * 在有序数组 arr 上，找满足小于等于 value 的最右位置
 *
 * @author: thirteenmj
 * @date: 2022-01-15 21:40
 */
public class Code06_BSNearRight {

    public static int nearRight(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        int mid = 0;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxLength = 100;
        int maxValue = 100;
        boolean isTrue = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxLength, maxValue);
            int target = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());

            int result1 = nearRight(arr, target);
            int result2 = test(arr, target);
            if (result1 != result2) {
                System.out.print("数组：");
                printArr(arr);
                System.out.println("目标值：" + target);
                System.out.println("算法结果：" + result1);
                System.out.println("对数器结果：" + result2);
                isTrue = false;
                break;
            }

        }
        System.out.println(isTrue ? "Nice" : "Fucking fucked");

    }

    public static int test(int[] arr, int target) {
        if (arr == null || arr.length == 0 ) {
            return -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= target) {
                return i;
            }
        }
        return -1;
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
        Arrays.sort(arr);
        return arr;
    }

}
