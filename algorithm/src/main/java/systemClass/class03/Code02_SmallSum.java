package systemClass.class03;

/**
 * 小合问题，求数组每一个数的左边比它小的数之合
 *
 * @author: thirteenmj
 * @date: 2022-05-11 16:12
 */
public class Code02_SmallSum {

    public static int smallSum(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        return  process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);

        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int leftIndex = l;
        int rightIndex = mid + 1;
        int index = 0;
        int[] help = new int[r - l + 1];
        int sum = 0;
        while (leftIndex <= mid && rightIndex <= r) {
            if (arr[leftIndex] < arr[rightIndex]) {
                help[index++] = arr[leftIndex];
                sum += (arr[leftIndex] * (r - rightIndex + 1));
                leftIndex++;
            } else {
                help[index++] = arr[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            help[index++] = arr[leftIndex++];
        }
        while (rightIndex <= r) {
            help[index++] = arr[rightIndex++];
        }

        for (int i = 0; i < (r - l + 1); i++) {
            arr[l + i] = help[i];
        }

        return sum;
    }

    public static int test(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int testTime = 1000;
        int maxLength = 1000;
        int maxValue = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int[] arr2 = copyArray(arr);
            int myAns = smallSum(arr);
            int testAns = test(arr2);
            if (myAns != testAns) {
                System.out.println("出错了！");
                System.out.print("数组:");
                printArray(arr2);
                System.out.println("myAns:" + myAns);
                System.out.println("testAns:" + testAns);
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
}
