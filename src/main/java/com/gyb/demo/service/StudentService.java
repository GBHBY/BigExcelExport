package com.gyb.demo.service;

import com.gyb.demo.bean.Student;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/25 16:03
 */

public interface StudentService {
    /**
     * create by: gb
     * description: 获取student集合
     * create time: 2021/2/25 16:08
     * @param sex
     * @param pageNum 页数
     * @param SIZE
     * @return
     */
    public List<Student> findBySex(String sex, Integer pageNum, Integer SIZE);
    /**
     * create by: gb
     * description: 获取总行数
     * create time: 2021/2/25 16:09
     * @param sex
     * @return
     */
    public int getRows(String sex);


}
