package com.gyb.demo.impl;

import com.gyb.demo.bean.Student;
import com.gyb.demo.dao.StudentDao;
import com.gyb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/2/25 16:04
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    public List<Student> findBySex(String sex, Integer pageNum, Integer size) {

        return dao.findBySex(sex,pageNum,size);
    }

    @Override
    public int getRows(String sex) {
        return 0;
    }
}
