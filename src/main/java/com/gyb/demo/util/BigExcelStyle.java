package com.gyb.demo.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/25 16:20
 */

public class BigExcelStyle {

    protected final Map<String, CellStyle> styleMap = new HashMap<>();

    /**
     * create by: gb
     * description: 表头格式
     * create time: 2021/2/25 16:21
     *
     * @param workbook
     * @return
     */
    protected CellStyle getHeadStyle(SXSSFWorkbook workbook) {

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 20);
        /**不一样**/
        font.setBold(true);
        style.setWrapText(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.MEDIUM);
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
    protected CellStyle getDataStyleEven(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
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
    protected CellStyle getTitleStyle(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        font.setColor(Font.COLOR_NORMAL);
        style.setFont(font);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }


    protected CellStyle getDataTextStyleEven(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("@"));
        return getCellStyle(style);
    }

    private CellStyle getCellStyle(CellStyle style) {
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setWrapText(false);
        return style;
    }


}
