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
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
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
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxSize);
            int[] arr1 = copyArray(arr);

            selectionSort(arr);
            Arrays.sort(arr1);

            if (!isEquals(arr, arr1)) {
                printArray(arr);
                printArray(arr1);
                succeed = false;
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
