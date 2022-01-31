package systemClass.class01;

/**
 * @author: thirteenmj
 * @date: 2022-01-19 22:23
 */
public class Code08_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static int findNumber(int[] arr) {
        int err = 0;

        for (int i = 0; i < arr.length; i++) {
            err ^= arr[i];
        }

        return err;
    }

    // arr中，有两种数，出现奇数次
    public static int[] findNumber2(int[] arr) {
        int err = 0;

        for (int i = 0; i < arr.length; i++) {
            err ^= arr[i];
        }

        int temp = err;
        int rightOne = err ^ (-err);

        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] & rightOne)) != 0) {
                err ^= arr[i];
            }
        }
        int[] result = new int[2];

        result[0] = err;
        result[1] = temp ^ err;

        return result;
    }


    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxSize = 100;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateAnOddArray(maxSize, maxValue);
            int myAnswer = findNumber(arr);
            int testAnswer = testOddNumber(arr);

            if (myAnswer != testAnswer) {
                printArr(arr);
                System.out.println("算法答案：" + myAnswer);
                System.out.println("对数器答案：" + testAnswer);
                System.out.println("垃圾");
                return;
            }
        }
        System.out.println("还可以噢");
        return;

    }

    public static int testOddNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArr(int[] arr) {
        System.out.print("数组：");
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private static int[] generateAnOddArray(int maxSize, int maxValue) {
        int length = 0;
        while (length % 2 == 0) {
            length =(int) ((maxSize * Math.random()) + 1);
        }

        int[] arr = new int[length];

        int oddTime = 0;
        int oddNumber = 0;
        while (oddTime % 2 == 0) {
            oddTime = (int) ((length * Math.random()) + 1);
        }

        while (oddNumber % 2 == 0) {
            oddNumber = (int) ((maxValue * Math.random()) + 1) - (int) (maxValue * Math.random());
        }

        for (int i = 0; i < oddTime; i++) {
            arr[i] = oddNumber;
        }

        for (int i = oddTime; i < length; i++) {
            arr[i] = oddNumber - 1;
        }

        return arr;
    }


}
