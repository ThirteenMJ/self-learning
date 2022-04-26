package beginClass.class05;

import java.util.stream.StreamSupport;

/**
 * 测试链接：https://leetcode.com/problems/divide-two-integers
 * 中文链接：https://leetcode-cn.com/problems/divide-two-integers/
 *
 * @author: thirteenmj
 * @date: 2022-04-26 01:53
 */
public class Code03_BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

    public static int subtract(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multiply(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(a, res);
            }
            a <<= 1;
            b >>>= 1;
        }

        return res;
    }

    private static boolean isNeg(int a) {
        return a < 0 ? true : false;
    }

    private static int negNum(int a) {
        return add(~a, 1);
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ?  negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = subtract(x, (y << i));
            }
        }

        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        } else if (dividend == Integer.MIN_VALUE){
            if (divisor == negNum(1)) {
                return Integer.MAX_VALUE;
            }
            int c = add(dividend, 1);
            int ans = div(c, divisor);
            return add(ans, div(subtract(dividend, multiply(ans, divisor)), divisor));
        } else {
            return div(dividend, divisor);
        }
    }

    public static void main(String[] args) {
        int a = -2147483648;
        int b = -1;
        System.out.println(divide(a, b));
    }
}
