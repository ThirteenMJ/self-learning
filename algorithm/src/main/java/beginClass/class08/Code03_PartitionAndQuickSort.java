package beginClass.class08;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快排
 *
 * @author: thirteenmj
 * @date: 2022-05-04 21:26
 */
public class Code03_PartitionAndQuickSort {

    /**
     * 递归实现快排
     *
     * @param arr
     */
    public static void quickSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int lessRight = left - 1;
        int moreLeft = right;
        int index = left;
        while (index < moreLeft) {
            if (arr[index] < arr[right]) {
                swap(arr, index++, ++lessRight);
            } else if (arr[index] > arr[right]){
                swap(arr, index, --moreLeft);
            } else {
                index++;
            }
        }
        swap(arr, moreLeft, right);
        process(arr, left, lessRight);
        process(arr, moreLeft + 1, right);
    }

    public static class Job {
        public int L;
        public int R;

        public Job() {
        }

        public Job(int l, int r) {
            L = l;
            R = r;
        }
    }

    /**
     * 非递归实现快排
     *
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        Job job = new Job(0, arr.length - 1);
        stack.push(job);
        while (!stack.isEmpty()) {
            Job pop = stack.pop();
            Job partition = partition(arr, pop.L, pop.R);
            if (partition.L > pop.L) {
                stack.push(new Job(pop.L, partition.L));
            }
            if (partition.R < pop.R) {
                stack.push(new Job(partition.R, pop.R));
            }
        }

    }

    public static Job partition(int[] arr, int left, int right) {
        if (left >= right) {
            return new Job(-1, -1);
        }
        int lessRight = left - 1;
        int moreLeft = right;
        int index = left;
        while (index < moreLeft) {
            if (arr[index] < arr[right]) {
                swap(arr, index++, ++lessRight);
            } else if (arr[index] > arr[right]){
                swap(arr, index, --moreLeft);
            } else {
                index++;
            }
        }
        swap(arr, moreLeft, right);
        return new Job(lessRight, moreLeft + 1);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxLength = 1000;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr = getNewArray(maxLength, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            Arrays.sort(arr1);
            quickSort2(arr2);
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
