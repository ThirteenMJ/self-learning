package beginClass;

/**
 * @author: thirteenmj
 * @date: 2022-04-07 21:42
 */
public class Code07_SelectionSort {

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
        int[] arr = {7, 3, 2, 4, 6, 8, 9, 1};
        selectSort(arr);
        printArray(arr);

    }
}
