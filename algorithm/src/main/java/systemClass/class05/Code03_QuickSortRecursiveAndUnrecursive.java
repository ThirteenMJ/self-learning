package systemClass.class05;

/**
 * 未完待续
 *
 * @author: thirteenmj
 * @date: 2022-05-17 20:23
 */
public class Code03_QuickSortRecursiveAndUnrecursive {

    public static void quickSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    private static int[] process(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[] {left, right};
        }

        return null;
    }
}
