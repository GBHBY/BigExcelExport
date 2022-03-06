package com.gyb.demo.controller;

import com.gyb.demo.util.QYExportService;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/3 16:32
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@RestController
@RequestMapping("qy")
public class QYExport {
    @Autowired
    private QYExportService exportExcel;

    @GetMapping("test")
    public String export() throws InterruptedException, IOException {
        long l = System.currentTimeMillis();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String format1 = format.format(date);
        String fileName = "QY统计.xlsx";
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
        try {
            exportExcel.exportExcel(file);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("完成组装：" + (System.currentTimeMillis() - l));
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
