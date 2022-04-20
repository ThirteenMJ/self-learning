package beginClass.class02;

/**
 * 1-7等概率出现 + 0和1不等概率返回，做一个0和1等概率返回的方法
 *
 * @author: thirteenmj
 * @date: 2022-04-20 14:44
 */
public class Class02_RandToRand {

    /**
     * 在 0-4 等概率出现
     *
     * @return
     */
    public static int f1() {
        return (int) (Math.random() * 5);
    }

    /**
     * 将 0-4等概率出现方法转换为 0/1 出现器
     *
     * @return
     */
    public static int f2() {
        int ans = f1();
        do {
            ans = f1();
        } while (ans == 0);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 0-7 随机产生
     *
     * @return
     */
    public static int f3() {
        int ans ;
        do {
           ans = (f2() << 2) + (f2() << 1) + f2();
        } while (ans == 0);
        return ans;
    }

    /**
     * 0 和 1 不等概率返回
     *
     * @return
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y() {
        int ans;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

    public static void main(String[] args) {
        int length = 8;
        int[] arr = new int[length];
        for (int i = 0; i < 100000; i++) {
            int ans = f3();
            arr[ans]++;
        }

        for (int i = 0; i < length; i++) {
            System.out.println(i + ":" + arr[i]);
        }

        System.out.println("=====================");

        int[] arr2 = new int[2];
        for (int i = 0; i < 100000; i++) {
            int ans = y();
            arr2[ans]++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i + ":" + arr2[i]);
        }

    }
}
