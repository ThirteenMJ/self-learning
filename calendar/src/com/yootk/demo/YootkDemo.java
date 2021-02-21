package com.yootk.demo;

import java.util.Calendar;

/**
 * @Author: thirteenmj
 * @Date: 2021/2/21 18:20
 */
public class YootkDemo {

    public static void main(String[] args) {

        //获取对象实例
        Calendar calendar = Calendar.getInstance();

        //通过9月计算8月的最后一天
        calendar.set(calendar.get(Calendar.YEAR), 8, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        System.out.println(String.format("当前的日期时间格式：%s-%s-%s %s:%s:%s",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)));
    }
}
