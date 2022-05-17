package systemClass.class03;

/**
 * arr 中 number > 右边 * 2 时的个数
 * 即指定数右边乘 2 还小于指定数的个数和
 * 测试链接: https://leetcode.com/problems/reverse-pairs/
 * 中文链接：https://leetcode.cn/problems/reverse-pairs/
 *
 * @author: thirteenmj
 * @date: 2022-05-11 16:12
 */
public class Code04_BiggerThanRightTwice {

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        int leftNumber = process(arr, l, mid);
        int rightNumber = process(arr, mid + 1, r);

        return leftNumber + rightNumber + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int ans = 0;
        int windowR = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (windowR <= r && arr[i] > (long)2 * arr[windowR]) {
                windowR++;
            }
            ans += windowR - mid -1;
        }

        int leftIndex = l;
        int rightIndex = mid + 1;
        int[] help = new int[(r - l + 1)];
        int index = 0;
        while (leftIndex <= mid && rightIndex <= r) {
            help[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            help[index++] = arr[leftIndex++];
        }
        while (rightIndex <= r) {
            help[index++] = arr[rightIndex++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] arr = {1,3,2,3,1};
//        int[] arr = {2,4,3,5,1};
//        int[] arr = {-5,-5};
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(arr));
//        printArray(arr);
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

}
