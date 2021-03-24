package tuling;

import java.util.function.Function;

/**
 * @author thirteenmj
 * Date: 2021/3/24 21:51
 */
public class SimpleLambda {

    public static void main(String[] args) {

        //执行一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello，鲁班");
            }
        }).start();


        new Thread(() -> System.out.println("hello，鲁班2")).start();

        //把代码逻辑当作参数进行传递
        System.out.println(getAge(a -> Integer.parseInt(a), "12"));
    }

    public static Integer getAge(Function<String, Integer> function, String args) {
        return function.apply(args);
    }
}
