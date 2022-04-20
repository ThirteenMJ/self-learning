package beginClass.class03;

import java.util.Arrays;

/**
 * 判断有序数组是否包含指定数
 * 查找 >= 指定数的最左位置
 *
 * @author: thirteenmj
 * @date: 2022-04-20 19:47
 */
public class Class02_BSExist {

    /**
     * 查找 >= number 最左的位置
     *
     * @param arr
     * @param number
     * @return
     */
    public static int moreLeftNoLessNumberIndex(int[] arr, int number) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= number) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    /**
     * 判断有序数组是否包含指定数
     *
     * @param arr
     * @param number
     * @return
     */
    public static boolean find(int[] arr, int number) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == number) {
                return true;
            } else if (arr[mid] < number) {
                left = mid + 1;
            } else  if (arr[mid] > number) {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int maxSize = 50;
        int maxValue = 20;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int number = (int) (((Math.random() * maxSize) + 1) - (Math.random() * maxSize));
            boolean myBoolean = find(arr, number);
            boolean testBoolean = testFind(arr, number);
            if (myBoolean != testBoolean) {
                System.out.println("出现错误");
                printArr(arr);
                System.out.println("number:" + number);
                System.out.println("是否发现：" + find(arr,number));
            }
            int myAnswer = moreLeftNoLessNumberIndex(arr, number);
            int testAnswer = testLeftNoLessNumberIndex(arr, number);
            if (myAnswer != testAnswer) {
                System.out.println("出现错误");
                printArr(arr);
                System.out.println("number:" + number);
                System.out.println("myAnswer:" + myAnswer);
                System.out.println("testAnswer:" + testAnswer);
                break;
            }
        }
        System.out.println("success");
    }

    /**
     * 测试 找出指定数在有序数组中的位置
     *
     * @param arr
     * @param number
     * @return
     */
    private static int testLeftNoLessNumberIndex(int[] arr, int number) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= number) {
                return i;
            }
        }
        return -1;
    }

    public static boolean testFind(int[] arr, int number) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建一个数组
     * Math.random() -> [0,1) 的所有小数，等概率的返回一个
     * Math.random() * N -> [0,N) 的所有小数，等概率的返回一个
     * (int) Math.random() * N -> [0, N - 1] 的所有整数，等概率返回一个
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxSize + 1) * Math.random()) - (int)(maxSize * Math.random());
        }
        Arrays.sort(arr);
        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
