package tuling;

/**
 * @author thirteenmj
 * Date: 2021/3/25 21:19
 */
@FunctionalInterface
public interface MyFunction {
    //1、加了FunctionalInterface注解
    //2、接口中只有唯一的一个抽象方法 自动推导认识成
    //3、如果多余的抽象方法是Object类中的方法 不影响 第一条规则
    void sayHello();
    String toString();
    default void sayHello2() {}
}
