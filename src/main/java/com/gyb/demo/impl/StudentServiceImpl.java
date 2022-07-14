package com.gyb.demo.impl;

import com.gyb.demo.bean.Student;
import com.gyb.demo.bean.StudentExample;
import com.gyb.demo.dao.StudentDao;
import com.gyb.demo.dao.StudentMapper;
import com.gyb.demo.service.StudentService;
import com.gyb.demo.util.MapResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int getRows() {
        StudentExample studentExample = new StudentExample();
        long row = dao.countByExample(studentExample);
        return (int) row;
    }

    @Override
    public List<Student> findAllStudent(int i, int y) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria().
                andSIdBetween(i, y);
        List<Student> students = dao.selectByExample(studentExample);
        return students;
    }

    @Override
    public Map<String, String> getMap() {


        List<Map<Object, Object>> map = mapper.getMap();
        Object value = map.get(0).get("value");


        System.out.println("123");


        return null;
    }
}
