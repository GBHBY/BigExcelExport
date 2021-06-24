package com.gyb.demo.impl;

import com.gyb.demo.bean.Student;
import com.gyb.demo.bean.StudentExample;
import com.gyb.demo.dao.StudentDao;
import com.gyb.demo.dao.StudentMapper;
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
    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> findBySex(String sex, Integer pageNum, Integer size) {

        return dao.findBySex(sex, pageNum, size);
    }

    @Override
    public int getRows() {
        StudentExample studentExample  = new StudentExample();
        long row = dao.countByExample(studentExample);
        return (int) row;
    }

    @Override
    public List<Student> findAllStudent(int i, int y) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria().
                andSIdBetween(String.valueOf(i), String.valueOf(y));
        return dao.selectByExample(studentExample);
    }
}
