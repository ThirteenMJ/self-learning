package beginClass;

/**
 * 选择排序 + 冒泡排序 + 插入排序
 *
 * @author: thirteenmj
 * @date: 2022-04-07 21:42
 */
public class Code07_SelectionSort {

    public static void insertSort1(int[] arr) {
        // 如果数组为空，或者数组的长度小于2，没必要进行排序
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int newSite = i;
            while (newSite - 1 >= 0 && arr[newSite - 1] > arr[newSite]) {
                swap(arr, newSite -1, newSite);
                newSite--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        // 如果数组为空，或者数组的长度小于2，没必要进行排序
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr, j , j + 1);
            }
        }
    }


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 如果数组为空，或者数组的长度小于2，没必要进行排序
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+ 1);
                }
            }
        }

    }

    /**
     * 交换两个位置的数
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void  selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minvalue = i;
            for (int j = i + 1; j < arr.length ; j++) {
                minvalue = arr[minvalue] < arr[j]? minvalue: j;
            }

            int temp = arr[i];
            arr[i] = arr[minvalue];
            arr[minvalue] = temp;

        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int maxLength = 10;
        int maxValue = 100;

        int[] arr = getNewArray(maxLength, maxValue);
        printArray(arr);
        insertSort2(arr);
        printArray(arr);

    }

    private static int[] getNewArray(int maxLength, int maxValue) {
        int length = (int) ((maxLength * Math.random()) + 1);
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (((maxValue) * Math.random() + 1) - (maxValue) * Math.random());
        }
        return arr;
    }
}
