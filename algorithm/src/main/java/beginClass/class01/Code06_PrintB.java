package beginClass.class01;

/**
 * 将数字的二进制 32 位打印出来
 *
 * @author: thirteenmj
 * @date: 2022-04-07 19:52
 */
public class Code06_PrintB {

    public static void print(int number) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((number & (1 << i)) == 0 ? 0 : 1));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int test = 1;
        print(test);
    }

}
