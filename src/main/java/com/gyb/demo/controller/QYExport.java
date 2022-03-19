package com.gyb.demo.controller;

import com.gyb.demo.util.QYExportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
@Api("qy导出")
@Slf4j
public class QYExport {
    @Autowired
    private QYExportService exportExcel;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("export")
    @ApiOperation("全量统计导出")
    @ApiImplicitParam(name = "date", value = "导出的日期")
    public String export(@RequestParam("date") String date) {
        long l = System.currentTimeMillis();
        Date fileDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String format1 = format.format(fileDate);
        String fileName = "QY统计.xlsx";
        String filePath = "D://";
        File file = new File(filePath + format1 + "-" + fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            log.error("创建文件失败", e);
            return "文件失败";
        } finally {
        }
        try {
            exportExcel.exportExcel(file, date);
        } catch (Exception e) {
            log.error("错误", e);
        }

        log.info("完成组装：{}毫秒", (System.currentTimeMillis() - l));
        String s = null;
        try {
            s = Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            long l1 = System.currentTimeMillis();
            log.info("导出时间：{}秒", (l1 - l) / 1000);
        }
        return s;


    }



}
