package nz2003.bLambda;

/**
 * @author thirteenmj
 * Date: 2021/3/24 22:42
 */
public class Lambda1 {

    private static interface Calculate {
        int calculate(int a, int b);
    }
    public static void main(String[] args) {
//        Calculate calculate = (x, y) -> calculate(x, y);
//        System.out.println(calculate.calculate(25, 25));
        //引用静态方法
//        Calculate calculate = Lambda1::calculate;
//        System.out.println(calculate.calculate(10,10));
        //引用非静态方法
        Calculate calculate = new Lambda1()::calculate2;
        System.out.println(calculate.calculate(10, 20));
    }

    private int calculate2(int a, int b) {
        if (a != b) {
            return a - b;
        }
        return b + a;
    }

    private static int calculate(int x, int y) {
        if (x > y) {
            return x - y;
        } else if (x < y) {
            return y - x;
        }
        return x + y;
    }
}
