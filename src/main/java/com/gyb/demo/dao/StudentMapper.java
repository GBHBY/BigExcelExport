package com.gyb.demo.dao;

import com.gyb.demo.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/6/16 23:34
 */
@Repository
public interface StudentMapper {
    /**
     * create by: gb
     * description: TODO
     * create time: 2021/7/17 15:05
     * @param i
     * @param y
     * @return
     */
     List<Student> findAllStudent(@Param("i") int i,@Param("y") int y);


}
