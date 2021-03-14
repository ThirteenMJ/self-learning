package com.kuang;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * @author thirteenmj
 * Date: 2021/3/14 23:31
 */
public class ExcelRead {

    public static String PATH = "src/main/resources/excel/";

    @Test
    public void testRead03() throws Exception {
        //获取文件流
        InputStream in = new FileInputStream(PATH + "狂神观众统计表03.xls");
        //1、创建一个工作薄(03)  使用excel能操作的，这边他都可以操作
        Workbook workbook = new HSSFWorkbook(in);
        //2、得到表
        Sheet sheet = workbook.getSheetAt(0);
        //3、得到行
        Row row = sheet.getRow(0);
        //4、得到单元格
        Cell cell = row.getCell(1);

        //读取值的时候一定要注意类型！
        //getStringCellValue 字符串类型
//        System.out.println(cell.getStringCellValue());
        System.out.println(cell.getNumericCellValue());

    }

    @Test
    public void testRead07() throws Exception {
        //获取文件流
        InputStream in = new FileInputStream(PATH + "狂神观众统计表07.xlsx");
        //1、创建一个工作薄(03)  使用excel能操作的，这边他都可以操作
        Workbook workbook = new XSSFWorkbook(in);
        //2、得到表
        Sheet sheet = workbook.getSheetAt(0);
        //3、得到行
        Row row = sheet.getRow(0);
        //4、得到单元格
        Cell cell = row.getCell(1);

        //读取值的时候一定要注意类型！
        //getStringCellValue 字符串类型
//        System.out.println(cell.getStringCellValue());
        System.out.println(cell.getNumericCellValue());

    }

    @Test
    public void testCellType() throws IOException {
        //获取文件流
        InputStream in = new FileInputStream(PATH + "明细表.xls");
        //创建一个工作薄(03)  使用excel能操作的，这边他都可以操作
        Workbook workbook = new HSSFWorkbook(in);
        Sheet sheet = workbook.getSheetAt(0);
        //获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            int rowCount = rowTitle.getPhysicalNumberOfCells();
            for (int i = 0; i < rowCount; i++) {
                Cell cell = rowTitle.getCell(i);
                if (cell != null) {
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue + " | ");
                }
            }
        }
        System.out.println();
        //获取表中内容
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null) {
                //读取列
                int cellCount = rowData.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    System.out.print("[" + (rowNum + 1) + "," + (cellNum + 1) + "]");
                    Cell cell = rowData.getCell(cellNum);
                    //匹配列的数据类型
                    if (cell != null) {
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType) {
                            //数字（日期/普通数字）
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    //日期
                                    System.out.print("[日期]");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");

                                } else {
                                    //不是日期格式，防止日期过长
                                    System.out.print("[转换为字符串输出]");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            //字符串
                            case HSSFCell.CELL_TYPE_STRING:
                                System.out.print("[STRING]");
                                cellValue = cell.getStringCellValue();
                                break;
                            //boolean类型
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                System.out.print("[BOOLEAN]");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            //空
                            case HSSFCell.CELL_TYPE_BLANK:
                                System.out.print("[BLANK]");
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                System.out.print("数据类型错误");
                                break;
                            default:
                                break;
                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        in.close();
    }
}
