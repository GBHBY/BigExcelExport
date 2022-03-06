package com.gyb.demo.thread;

import com.gyb.demo.bean.QYEntity;
import com.gyb.demo.controller.QYExport;
import com.gyb.demo.util.QYExportService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * @author 郭煜博
 * @version 1.0
 * description:
 * @date 2021/10/3 3:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QYThread implements Runnable {
    private int half;
    private int size;
    private QYExportService qyExportService;
    private QYExport qyExport;
    private Sheet sheet;
    private int index;
    private int number;
    private int start;



    @Override
    public void run() {
        List<QYEntity> studentList1;
            studentList1 = qyExportService.findAll();
            for (QYEntity item : studentList1) {
                qyExportService.createEveryRow(sheet, item, index++, number++);
            }
            studentList1.clear();

    }
}
