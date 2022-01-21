package systemClass.class01;

import java.util.Arrays;
import java.util.List;

/**
 * 查询某个数在有序数组中的是否存在
 *
 * @author: thirteenmj
 * @date: 2022-01-15 21:40
 */
public class Code04_BSExist {

    public static boolean exist(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (number == arr[mid]) {
                return true;
            } else if (number > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return arr[left] == number ? true : false;
    }

    public static void main(String[] args) {
        // 测试次数
        int testTime = 500000;
        // 随机数组长度 0-100
        int maxSize = 100;
        // 值 -100～100
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);

            int target = (int)((maxValue + 1) * Math.random());

            boolean fact1 = exist(arr, target);
            boolean fact2 = isContains(arr, target);

            if (fact1 != fact2) {
                System.out.println("第" + i + "次");
                System.out.println("自写方法结果为：" + fact1);
                System.out.println("自带方法结果为：" + fact2);
                printArr(arr);
                System.out.println("目标数为：" + target);
                System.out.println("Fucking fucked");
                return;
            }
        }
        System.out.println("Nice");


    }

    public static boolean isContains(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }

        return false;
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

}
