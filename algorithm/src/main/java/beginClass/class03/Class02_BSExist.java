package beginClass.class03;

import java.util.Arrays;

/**
 * @author: thirteenmj
 * @date: 2022-04-20 19:47
 */
public class Class02_BSExist {

    /**
     * 根据二分法查找有序数组中的指定数的位置
     *
     * @param arr
     * @param number
     * @return
     */
    public static boolean find(int[] arr, int number) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == number) {
                return true;
            } else if (arr[mid] < number) {
                left = mid + 1;
            } else  if (arr[mid] > number) {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int maxSize = 50;
        int maxValue = 20;
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArr(arr);
        int number = (int) (((Math.random() * maxSize) + 1) - (Math.random() * maxSize));
        System.out.println("number:" + number);
        System.out.println("是否发现：" + find(arr,number));
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
}
