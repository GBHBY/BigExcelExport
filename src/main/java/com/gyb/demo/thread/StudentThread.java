package com.gyb.demo.thread;

import com.gyb.demo.bean.Student;
import com.gyb.demo.impl.StudentServiceImpl;
import com.gyb.demo.service.StudentService;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/7/14 15:10
 */

public class StudentThread implements Callable {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    public List<Student> call() throws Exception {
        return null;
    }
}
