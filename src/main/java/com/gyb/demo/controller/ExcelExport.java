package com.gyb.demo.controller;

import com.gyb.demo.util.StudentExport;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

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
     * @param sex
     * @return
     */
    @GetMapping("test")
    public String export(@RequestParam("id") String sex) {

        try {
            if (StringUtils.isEmpty(sex)) {
            }
        } catch (Exception e) {
            return "id为空";
        }
        String fileName = "学生表.xlsx";
        String filePath = "D://";
        File file = new File(filePath + fileName);
        if (file.exists()) {
            file.delete();

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创造文件失败");
            } finally {
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创造文件失败");
            } finally {
            }
        }

        studentExport.exportExcel(file, sex);
        String s = null;
        try {
            s = Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


        return s;


    }

}
