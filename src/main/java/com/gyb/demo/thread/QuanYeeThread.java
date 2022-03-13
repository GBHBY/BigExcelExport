package com.gyb.demo.thread;

import com.gyb.demo.bean.QYEntity;
import com.gyb.demo.controller.QYExport;
import com.gyb.demo.util.QYExportService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("导出线程")
public class QuanYeeThread implements Runnable {
    @ApiModelProperty(value = "一次从数据库拿出的数量")
    private int half;

    @ApiModelProperty(value = "数据量总大小")
    private int size;

    @ApiModelProperty(value = "导出实现类")
    private QYExportService qyExportService;

    @ApiModelProperty(value = "一次从数据库拿出的数量")
    private QYExport qyExport;
    @ApiModelProperty(value = "sheet名称")
    private Sheet sheet;
    @ApiModelProperty(value = "行数")
    private int index;
    @ApiModelProperty(value = "第几行")
    private int number;
    @ApiModelProperty(value = "")
    private int start;

    private String date;


    @Override
    public void run() {
        List<QYEntity> studentList1;
        studentList1 = qyExportService.findAll(date);
        for (QYEntity item : studentList1) {
            qyExportService.createEveryRow(sheet, item, index++, number++);
        }
        studentList1.clear();

    }
}
