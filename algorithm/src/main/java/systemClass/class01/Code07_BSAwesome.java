package systemClass.class01;

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

        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] < mid + 1){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
