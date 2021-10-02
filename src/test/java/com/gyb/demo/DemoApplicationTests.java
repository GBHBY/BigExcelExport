package com.gyb.demo;

import com.gyb.demo.bean.Student;
import com.gyb.demo.bean.StudentExample;
import com.gyb.demo.dao.StudentDao;
import com.gyb.demo.dao.StudentMapper;
import com.gyb.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class DemoApplicationTests {
    public static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentMapper mapper;

    @Test
    void test1() throws IOException, InterruptedException {
        long l = System.currentTimeMillis();
        File file = new File("D://demo.txt");
        StudentExample example = new StudentExample();
        StudentExample.Criteria criterion = example.createCriteria().andSIdBetween(1, 10000);
        List<Student> students = studentDao.selectByExample(example);
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        int y = students.size();
        int d = y / 2;
        Thread t = new Thread(() -> {
            for (int i = 0; i < d; i++) {

                builder.append(students.get(i).toString() + Thread.currentThread().getName() + "\r\n");
            }
        }, "demo1");
        t.start();

        Thread t1 = new Thread(() -> {
            for (int i = d; i < y; i++) {

                builder1.append(students.get(i).toString() + Thread.currentThread().getName() + "\r\n");
                System.out.println(students.get(i).toString() + Thread.currentThread().getName());
            }
        }, "demo2");

        t1.start();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        TimeUnit.SECONDS.sleep(1);
        bufferedWriter.write(String.valueOf(builder));
        bufferedWriter.write(String.valueOf(builder1));
        bufferedWriter.close();
        System.out.println("test1耗时" + (System.currentTimeMillis() - l));
    }


    @Test
    void test2() throws IOException {
        long l = System.currentTimeMillis();
        File file = new File("D://demo1.txt");
        StudentExample example = new StudentExample();
        StudentExample.Criteria criterion = example.createCriteria().andSIdBetween(1, 20);
        List<Student> students = studentDao.selectByExample(example);
        StringBuilder builder = new StringBuilder();
        int y = students.size();
        for (int i = 0; i < y; i++) {
            builder.append(students.get(i).toString() + "demo1" + "\r\n");
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write(String.valueOf(builder));
        bufferedWriter.close();
        System.out.println("test2耗时" + (System.currentTimeMillis() - l));
    }

    @Test
    void test3() {
//        mapper.findAllStudent(1, 10)

    }

}
