package systemClass.class03;

/**
 * 欠：对数器
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
        int index = l;
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
            help[index++] = arr[leftIndex];
            sum += (arr[leftIndex] * (r - rightIndex + 1));
        }
        while (rightIndex <= mid) {
            help[index++] = arr[rightIndex++];
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
