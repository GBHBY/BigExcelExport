package com.gyb.demo.thread;

import com.gyb.demo.bean.Student;
import com.gyb.demo.service.StudentService;
import com.gyb.demo.util.StudentExport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 郭煜博
 * @version 1.0
 * description:
 * @date 2021/10/3 3:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ExportThread implements Runnable {
    private final CountDownLatch cdl;
    private int half;
    private int size;
    private StudentService studentService;
    private StudentExport studentExport;
    private Sheet sheet;
    private int index;
    private int number;
    private int start;



    @Override
    public void run() {
        List<Student> studentList1;
        for (int i = 1; i <= (half + size - 1) / size; i++) {
            int y = (i - 1) * size + start;
            studentList1 = studentService.findAllStudent(y, y + size - 1);
            for (Student student : studentList1) {
                studentExport.createEveryRow(sheet, student, index++, number++);
            }
            studentList1.clear();
        }
        cdl.countDown();

    }
}
