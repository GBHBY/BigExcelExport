package com.gyb.demo.util;

import com.gyb.demo.bean.Student;
import com.gyb.demo.service.StudentService;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/25 15:52
 */
@Component
public class StudentExport extends BigExcelStyle {
    private static int SIZE = 10000;
    @Autowired
    private StudentService studentService;

    public void exportExcel(File file, String sex) {
        int row = studentService.getRows(sex);
        List<Student> studentList = new ArrayList<>();
        SXSSFWorkbook wb = new SXSSFWorkbook(5000);
        wb.setCompressTempFiles(true);
        styleMap.clear();
        styleMap.put("title", getTitleStyle(wb));
        styleMap.put("head", getHeadStyle(wb));
        styleMap.put("text", getDataTextStyleEven(wb));
        styleMap.put("date", getDataStyleEven(wb));
        Sheet sheet = wb.createSheet("demo");
        createHeadRow(wb, sheet);
        int index = 1;
        int number = 1;
       /* for (int i = 1; i <= (row + SIZE - 1) / SIZE; i++) {
            studentList = studentService.findBySex(sex, (i - 1) * SIZE, SIZE);
            for (Student student : studentList) {
                createEveryRow(wb, sheet, student, index++, number++);
            }
            studentList.clear();
        }*/
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }

    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2021/2/25 19:27
     *
     * @param wb
     * @param sheet
     * @param student
     * @param i
     * @param number
     * @return
     */
    private void createEveryRow(SXSSFWorkbook wb, Sheet sheet, Student student, int i, int number) {
        Row row1 = sheet.createRow(i);
        int line = 0;
        Cell cell1 = row1.createCell(line++);
        cell1.setCellValue(number);
        cell1.setCellStyle(styleMap.get("text"));

        Cell cell2 = row1.createCell(line++);
        cell2.setCellValue(student.getsId());

        Cell cell3 = row1.createCell(line++);
        cell3.setCellValue(student.getsBirth());
        cell3.setCellStyle(styleMap.get("text"));

        Cell cell4 = row1.createCell(line++);
        cell4.setCellValue(student.getsSex());
        cell4.setCellStyle(styleMap.get("text"));

    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2021/2/25 19:27
     *
     * @param
     * @return
     */
    private void createHeadRow(SXSSFWorkbook wb, Sheet sheet) {
        int line = 0;
        Row sheetTitleRow = sheet.createRow(0);
        sheetTitleRow.setHeightInPoints(20);
        Cell cell0 = sheetTitleRow.createCell(line++);
        cell0.setCellValue("序号");
        cell0.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(0, "序号".getBytes().length * 2 * 256);
        Cell cell1 = sheetTitleRow.createCell(line++);
        cell1.setCellValue("id");
        cell1.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(1, "id".getBytes().length * 2 * 256);
        Cell cell2 = sheetTitleRow.createCell(line++);
        cell2.setCellValue("名字");
        cell2.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(2, "名字".getBytes().length * 2 * 256);
        Cell cell3 = sheetTitleRow.createCell(line++);
        cell3.setCellValue("出生日期");
        cell3.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(3, "出生日期".getBytes().length * 2 * 256);
        Cell cell4 = sheetTitleRow.createCell(line++);
        cell4.setCellValue("性别");
        cell4.setCellStyle(styleMap.get("head"));
        sheet.setColumnWidth(4, "性别".getBytes().length * 2 * 256);

    }

}
