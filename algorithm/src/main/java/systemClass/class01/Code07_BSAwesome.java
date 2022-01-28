package systemClass.class01;

import java.util.ArrayList;
import java.util.List;

/**
 * 无序数组，任意相邻的数不相等，找出任意一个局部最小的位置
 *
 * @author: thirteenmj
 * @date: 2022-01-25 22:37
 */
public class Code07_BSAwesome {

    public static int aweSome(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxLength = 10;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxLength, maxValue);
            printArr(arr);
            int result = aweSome(arr);

            if (!contains(arr, result)) {
                System.out.println("Fucking fucked");
                System.out.println();
                return;
            }

            System.out.println("Nice");
            System.out.println();
        }

    }

    /**
     * 返回所有符合局部最小定义的索引集合
     *
     * @param arr
     * @return
     */
    private static boolean contains(int[] arr, int value) {
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            list.add(-1);
        } else if (arr.length == 1 || arr[0] < arr[1]) {
            list.add(0);
        } else {
            if (arr[arr.length - 1] < arr[arr.length - 2]) {
                list.add(arr.length -  1);
            }

            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    list.add(i);
                }
            }
        }

        System.out.println("所有的位置：" + list.toString());
        System.out.println("算法位置：" + value);

        return list.contains(value);

    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArr(int[] arr) {
        System.out.print("数组：");
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

        // 检查前后是否相同
        for (int i = 0; i < arr.length - 1 ; i++) {
            if (arr[i] == arr[i + 1]) {
                while ((arr[i + 1] = generateInt(maxSize)) == arr[i]){
                }
            }
        }

        return arr;
    }

    private static int generateInt(int maxSize) {
        int value = (int)((maxSize + 1) * Math.random()) - (int)(maxSize * Math.random());
        return value;
    }
}
