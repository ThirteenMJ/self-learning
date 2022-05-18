package systemClass.class06;


import java.util.Arrays;

/**
 * 利用大根堆进行排序
 *
 * @author: thirteenmj
 * @date: 2022-05-18 15:28
 */
public class Code03_HeapSort {

    public static void heapSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        // 这一步是将整个数组进行排序
        // 有两种方法进行选择 复杂度不同
        // o（N * log N）
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // o(N)
//        for (int i = arr.length - 1; i >= 0; i--) {
//            heapify(arr, i, arr.length);
//        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, ((index - 1) / 2));
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int maxIndex) {
        int left = 2 * index + 1;
        while (left < maxIndex) {
            int large = left + 1 < maxIndex && arr[left + 1] > arr[left] ? left + 1 : left;
            large = arr[index] < arr[large]? large : index;
            if (index == large) {
                break;
            }

            swap(arr, index, large);
            index = large;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int index, int target) {
        int temp = arr[index];
        arr[index] = arr[target];
        arr[target] = temp;
    }

    public static void main(String[] args) {
        int maxValue = 1000;
        int maxLength = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            heapSort(arr2);
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
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
