package systemClass.class01;

import org.omg.CORBA.ARG_OUT;

import java.util.*;

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
    public static List<Integer> findNumber2(int[] arr) {
        int err = 0;

        for (int i = 0; i < arr.length; i++) {
            err ^= arr[i];
        }

        int temp = err;
        int rightOne = err & (-err);

        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] & rightOne)) != 0) {
                err ^= arr[i];
            }
        }
        List<Integer> list = new ArrayList<>();

        list.add(err);
        list.add(err ^ temp);

        return list;
    }


    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxSize = 100;

        // 测试一个奇数算法是否正确
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateAnOddArray(maxSize, maxValue);
            int myAnswer = findNumber(arr);
            int testAnswer = testAnOddNumber(arr);

            if (myAnswer != testAnswer) {
                printArr(arr);
                System.out.println("一个奇数算法答案：" + myAnswer);
                System.out.println("一个奇数对数器答案：" + testAnswer);
                System.out.println("垃圾");
                return;
            }
        }

        // 测试两个奇数算法是否有问题
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateTwoOddArray(maxSize, maxValue);
            List<Integer> myAnswer = findNumber2(arr);
            List<Integer> testAnswer = testTwoOddNumber(arr);

            if (!isCorrect(myAnswer, testAnswer)) {
                printArr(arr);
                System.out.println("两个奇数算法答案：" + myAnswer);
                System.out.println("两个奇数对数器答案：" + testAnswer);
                System.out.println("垃圾");
                return;
            }


        }

        System.out.println("还可以噢");
        return;

    }

    /**
     * 验证两个集合是否一直
     *
     * @param myAnswer
     * @param testAnswer
     * @return
     */
    private static boolean isCorrect(List<Integer> myAnswer, List<Integer> testAnswer) {
        if (myAnswer == null && testAnswer == null) {
            return true;
        }

        if (myAnswer == null && testAnswer != null) {
            return false;
        }

        if (myAnswer != null && testAnswer == null) {
            return false;
        }

        if (myAnswer.size() == 0 && myAnswer.size() == 0) {
            return true;
        }

        if (myAnswer.size() != testAnswer.size()) {
            return false;
        }

        for (int i = 0; i < myAnswer.size(); i++) {
            if (!testAnswer.contains(myAnswer.get(i))) {
                return false;
            }

        }

        return true;
    }


    /**
     *
     *
     * @param arr
     * @return
     */
    public static List<Integer> testTwoOddNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (map.get(next) % 2 != 0) {
                list.add(next);
            }
        }

        return list;
    }

    /**
     * 测试只有一个奇数时的答案
     *
     * @param arr
     * @return
     */
    public static int testAnOddNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (map.get(next) % 2 != 0) {
                return next;
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

    private static int[] generateTwoOddArray(int maxSize, int maxValue) {
        int length = -1;

        while (length % 2 != 0) {
            length =(int) ((maxSize * Math.random()) + 1);
        }

        int[] arr = new int[length];

        int oneOddTime = 0;
        int twoOddTime = 0;
        int oneOddNumber = 0;
        int twoOddNumber = 0;
        int constants = 0;
        while (oneOddTime % 2 == 0 || twoOddTime % 2 == 0 ||
                (oneOddTime + twoOddTime) > length ||
                constants == oneOddNumber || constants == twoOddNumber
                ||oneOddNumber == twoOddNumber) {
            oneOddTime = (int) ((length * Math.random()) + 1);
            oneOddNumber = (int) ((maxValue * Math.random()) + 1);
            twoOddTime = (int) ((length * Math.random()) + 1);
            twoOddNumber = (int) ((maxValue * Math.random()) + 1);
            constants = (int) ((maxValue * Math.random()) + 1);
        }

        for (int i = 0; i < oneOddTime; i++) {
            arr[i] = oneOddNumber;
        }

        for (int i = 0; i < twoOddTime; i++) {
            arr[i + oneOddTime] = twoOddNumber;
        }

        for (int i = oneOddTime + twoOddTime; i < length; i++) {
            arr[i] = constants;
        }

        return arr;
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
