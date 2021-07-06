package com.gyb.demo;

import com.gyb.demo.bean.Student;
import com.gyb.demo.bean.StudentExample;
import com.gyb.demo.dao.StudentDao;
import com.gyb.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class DemoApplicationTests {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDao studentDao;


    @Test
    void contextLoads() {
        int i  = 0;
        test1(++i);
    }

    void test1(int i ){
        System.out.println(i);
    }

}
