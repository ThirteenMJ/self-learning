package com.kuang.easy;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.junit.Test;

import java.util.Date;

/**
 * @author thirteenmj
 * Date: 2021/3/15 21:33
 */
@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleDate;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
