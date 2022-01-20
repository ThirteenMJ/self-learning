package systemClass.class01;


import java.util.Arrays;

/**
 * @author: thirteenmj
 * @date: 2022-01-19 22:51
 */
public class Code01_SelectionSort {

    /**
     * 按照升序进行排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);
        }
    }

    /**
     * 交换两个位置的数字
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 9;
        int maxSize = 100;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generationArray(maxValue, maxSize);
            int[] arr1 = copyArray(arr);

            sort(arr);
            Arrays.sort(arr1);

            if (!isEquals(arr, arr1)) {
                printArray(arr);
                printArray(arr1);
                System.out.println("算法有问题");
                break;
            }
        }
        System.out.println("算法没问题");

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
