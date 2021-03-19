package com.itheima.pattern.factory.before;

/**
 * @author thirteenmj
 * Date: 2021/3/19 23:11
 *
 * 咖啡店
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        //声明Coffee类型的变量，然后根据不同类型创建不同的Coffee子类对象
        Coffee coffee = null;
        if ("AmericanCoffee".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("LatteCoffee".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡我们店里不卖");
        }
        //加配料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
