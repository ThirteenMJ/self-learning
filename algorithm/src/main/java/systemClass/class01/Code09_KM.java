package systemClass.class01;

import java.util.HashMap;

/**
 * 有一种数出现了 K 次，其余的数出现了 M 次，求 出现了 K 次的数，M > 1, K < M，要求 空间复杂度 o（1），o（N^2）
 *
 * @author: thirteenmj
 * @date: 2022-05-05 22:16
 */
public class Code09_KM {

    public static int findKTimeNumber(int[] arr, int k, int m) {
        if (null == arr || arr.length < 1) {
            return -1;
        }

        int[] ans = new int[32];
        int result = 0;
        for (int number : arr) {
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & number) != 0) {
                    ans[i]++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            if (ans[i] % m != 0) {
                if (ans[i] % m == k){
                    result |= (1 << i);
                } else {
                    return -1;
                }
            }
        }
        if (result == 0) {
            int zeroTime = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    zeroTime++;
                }
            }
            if (zeroTime != k){
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxValue = 100;
        int maxKinds = 10;
        for (int i = 0; i < testTime; i++) {
            int k = 0;
            int m = 0;
            do {
                k = ((int) (maxValue * Math.random())) + 1;
                m = ((int) (maxValue * Math.random())) + 1;
            } while (k >= m);

            if (k == m) {
                m++;
            }
            int[] arr = generationArray(maxValue, maxKinds, k, m);

            int myAns = findKTimeNumber(arr, k, m);
            int testAns = test(arr, k, m);
            if (myAns != testAns) {
                System.out.println("出错了");
                System.out.println("原数组：");
                printArray(arr);
                System.out.println("k:" + k);
                System.out.println("m:" + m);
                System.out.println("myAns:" + myAns);
                System.out.println("testAns:" + testAns);
                return;
            }
        }
        System.out.println("success");
    }

    private static int test(int[] arr,int k, int m){
        if (null == arr || arr.length < 1) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == k) {
                return key;
            }
        }
        return -1;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 随机生成一个数组
     *
     * @param maxValue
     * @param maxKinds
     * @param k
     * @param m
     * @return
     */
    private static int[] generationArray(int maxValue, int maxKinds, int k, int m) {
        int kinds = (int) ((Math.random() * maxKinds) + 2);
        int[] arr = new int[k + ((kinds - 1) * m)];
        int kNumber = (int) ((Math.random() * maxValue) + 1) - (int) ((Math.random() * maxValue) + 1);
        int index = 0;
        for (; index < k; index++) {
            arr[index] = kNumber;
        }
        kinds--;
        while (kinds > 0) {
            int mNumber = 0;
            do {
                mNumber = (int) ((Math.random() * maxValue) + 1) - (int) ((Math.random() * maxValue) + 1);
            } while (mNumber == kNumber);
            for (int i = 0; i < m; i++, index++) {
                arr[index] = mNumber;
            }
            kinds--;
        }

        for (int i = 0; i < arr.length; i++) {
            int index1 = (int) (arr.length * Math.random());
            int index2 = (int) (arr.length * Math.random());
            swap(arr, index1, index2);
        }

        return arr;
    }

    /**
     * 交换两个位置的数字
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
