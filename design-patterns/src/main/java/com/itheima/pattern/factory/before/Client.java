package com.itheima.pattern.factory.before;

/**
 * @author thirteenmj
 * Date: 2021/3/19 23:18
 */
public class Client {

    public static void main(String[] args) {

        //1、创建咖啡店对象
        CoffeeStore store = new CoffeeStore();
        //2、点咖啡
        Coffee coffee = store.orderCoffee("AmericanCoffee");
        System.out.println(coffee.getName());
    }
}
