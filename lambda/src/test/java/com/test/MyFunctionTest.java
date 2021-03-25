package com.test;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author thirteenmj
 * Date: 2021/3/25 21:30
 */
public class MyFunctionTest {

    public interface MyInterface {
        void sayHello(String name, String content);
    }

    public interface MyInterface2 {
        String  sayHello(String name, String content);
    }

    @Test
    public void test3() {
        MyInterface2 i = (String n, String c) -> {
            System.out.println(n);
            System.out.println(c);
            return n + c;
        };
        i.sayHello("luban,", "how are you");
    }

    @Test
    public void test2() {
        MyInterface f = (n, c) -> System.out.println(n + c);
        f.sayHello("luban,", "how are you");
    }

    @Test
    public void test() {
        Function<String, String> f = t -> t;
        System.out.println(f.apply("luban"));
    }
}
