package com.gyb.demo.service;

import com.gyb.demo.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/25 16:03
 */

public interface StudentService {

    /**
     * create by: gb
     * description: 获取总行数
     * create time: 2021/2/25 16:09
     *
     * @return
     */
    int getRows();

    /**
     * create by: gb
     * description: 查询所有的学生，并且分页
     * create time: 2021/6/16 23:36
     *
     * @param i
     * @param size
     * @return
     */

    List<Student> findAllStudent(int i, int size);

    /**
     * 测试mybatis返回map
     * @return
     */
    Map<String,String> getMap();
}
