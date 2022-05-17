package systemClass.class05;

/**
 * 测试地址：https://leetcode.com/problems/count-of-range-sum/
 * 中文地址：https://leetcode.cn/problems/count-of-range-sum/
 *
 * @author: thirteenmj
 * @date: 2022-05-11 16:43
 */
public class Code01_CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (null == nums || nums.length < 1) {
            return -1;
        }

        long[] arr = new long[nums.length];

        arr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }

        return process(arr, 0, arr.length - 1, lower, upper);
    }

    private static int process(long[] arr, int left, int right, int lower, int upper) {
        if (null == arr || arr.length < 1) {
            return -1;
        }

        if (right == left) {
            if (arr[left] <= upper && arr[right] >= lower) {
                return 1;
            } else {
                return 0;
            }
        }

        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid, lower, upper)
                + process(arr, mid + 1, right, lower, upper)
                + merge(arr, left, mid, right,lower, upper);
    }

    private static int merge(long[] arr, int left, int mid, int right, int lower, int upper) {
        int windLeft = left;
        int windRight = left;
        int ans = 0;
        for (int i = mid + 1; i <= right; i++) {
            long max = arr[i] - lower;
            long min = arr[i] - upper;
            while (windRight <= mid && arr[windRight] <= max) {
                windRight++;
            }
            while (windLeft <= mid && arr[windLeft] < min) {
                windLeft++;
            }
            ans += windRight - windLeft;
        }

        int leftIndex = left;
        int rightIndex = mid + 1;
        long[] help = new long[right - left + 1];
        int index = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            help[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while (leftIndex <= mid){
            help[index++] = arr[leftIndex++];
        }
        while (rightIndex <= right){
            help[index++] = arr[rightIndex++];
        }

        for (int i = 0; i < right - left + 1; i++) {
            arr[left + i] = help[i];
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,5,-1};
//        int lower = -2;
//        int upper = 2;
//        int[] nums = {2147483647, -2147483648, -1, 0};
//        int lower = -1;
//        int upper = 0;
        int[] nums = {-2147483647, 0, -2147483647, 2147483647};
        int lower = -564;
        int upper = 3864;
        System.out.println(countRangeSum(nums, lower, upper));
    }

}
