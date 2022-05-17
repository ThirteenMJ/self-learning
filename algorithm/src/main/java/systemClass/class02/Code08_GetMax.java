package systemClass.class02;

/**
 *
 * @author: thirteenmj
 * @date: 2022-05-11 16:11
 */
public class Code08_GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length -1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int maxValue = 10;
        int testTime = 10000;
        int maxLength = 10;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxValue, maxLength);
            int myMax = getMax(arr);
            int testMax = test(arr);
            if (myMax != testMax) {
                System.out.println("出错了");
                System.out.println("myMax:" + myMax);
                System.out.println("testMax:" + testMax);
                return;
            }
        }
        System.out.println("success");
    }

    private static int test(int[] arr) {
        if (null == arr || arr.length == 0) {
            throw new RuntimeException("数组不能为空");
        }
        int max = arr[0];

        for (int number : arr) {
            if (number > max) {
                max = number;
            }
        }

        return max;
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
        int size = (int) ((maxLength + 1) * Math.random()) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
