package com.gyb.demo.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/25 16:20
 */

public class BigExcelStyle {

    protected final Map<String, XSSFCellStyle> styleMap = new HashMap<>();

    /**
     * create by: gb
     * description: 表头格式
     * create time: 2021/2/25 16:21
     *
     * @param workbook
     * @return
     */
    protected XSSFCellStyle getHeadStyle(SXSSFWorkbook workbook) {

        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 20);
        /**自动换行**/
        style.setWrapText(false);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        return style;
    }

    /**
     * create by: gb
     * description: 文字格式
     * create time: 2021/2/25 18:23
     *
     * @param workbook
     * @return
     */
    protected XSSFCellStyle getDataStyleEven(SXSSFWorkbook workbook) {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-mm-dd"));
        style.setWrapText(true);
        return getCellStyle(style);

    }

    /**
     * create by: gb
     * description: 标题行格式
     * create time: 2021/2/25 18:31
     *
     * @param
     * @return
     */
    protected XSSFCellStyle getTitleStyle(SXSSFWorkbook workbook) {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        font.setColor(Font.COLOR_NORMAL);
        style.setFont(font);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }


    protected XSSFCellStyle getDataTextStyleEven(SXSSFWorkbook workbook) {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-mm-dd"));
        return getCellStyle(style);
    }

    protected static XSSFCellStyle getCellStyle(XSSFCellStyle style) {
        style.setWrapText(false);
        // 水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 前景颜色
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        // 边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        return style;
    }


    protected XSSFCellStyle getAndSetXSSFCellStyleHeader(SXSSFWorkbook sxssfWorkbook) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
        Font font = sxssfWorkbook.createFont();
        // 字体大小
        font.setFontHeightInPoints((short) 14);
        // 字体粗细
//        font.setBoldweight((short) 20);
//        font.setFontName("楷体");
        // 将字体应用到样式上面
        xssfCellStyle.setFont(font);
        // 是否自动换行
        xssfCellStyle.setWrapText(false);
        // 水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return xssfCellStyle;
    }


}
