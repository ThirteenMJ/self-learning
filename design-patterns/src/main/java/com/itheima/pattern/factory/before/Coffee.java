package com.itheima.pattern.factory.before;

/**
 * @author thirteenmj
 * Date: 2021/3/19 23:02
 *
 * 咖啡类
 */
public abstract class Coffee {

    public abstract String getName();

    //加糖
    public void addSugar() {
        System.out.println("加糖");
    }

    //加奶
    public void addMilk() {
        System.out.println("加奶");
    }
}
