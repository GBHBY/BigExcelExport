package com.gyb.demo.controller;

import com.gyb.demo.util.StudentExport;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gb
 * @version 1.0
 * description: 10W+数据导出
 * @date 2021/2/25 15:04
 */
@RestController
@RequestMapping("export")
public class ExcelExport {
    @Autowired
    private StudentExport studentExport;


    /**
     * create by: gb
     * description: TODO
     * create time: 2021/2/25 15:48
     *
     * @return
     */
    @GetMapping("test")
    public String export() throws InterruptedException, IOException {
        long l = System.currentTimeMillis();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String format1 = format.format(date);
        String fileName = "学生表.xlsx";
        String filePath = "D://";
        File file = new File(filePath + format1 + "-" + fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("创造文件失败");
            return "文件失败";
        } finally {
        }
        studentExport.exportExcel(file);
        System.out.println("完成组装："+ (System.currentTimeMillis()-l));
        String s = null;
        try {
            s = Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


        }
        long l1 = System.currentTimeMillis();
        System.out.println("导出时间：" + (l1 - l) / 1000);


        return s;


    }

}
