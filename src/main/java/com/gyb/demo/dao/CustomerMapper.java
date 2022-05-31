package com.gyb.demo.dao;

import com.gyb.demo.bean.*;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author GB
 * @date 2022/3/3 16:40
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) {2022}. All Rights Reserved.
 * </pre>
 */
@Repository
public interface CustomerMapper {

    List<DepartmentDO> finadAllDept();

    List<QYEntity> findNum(@Param("ids") List<Long> deptIds);

    List<CustomerDept> findAllEmp(@Param("path") String dept);

    Integer getYestodayAddLose(@Param("ids") List<Long> customerId);

    Integer getYestodayLose(@Param("ids") List<Long> value,@Param("delete")String tag);

    /**
     * 计算累计的
     * @param value
     * @param none
     * @param date
     * @return
     */
    int count(@Param("ids") List<Long> value, @Param("delete") String none,@Param("date") LocalDate date);


    List<Long> selectAddCustomerIds(@Param("ids") List<Long> value,@Param("date") LocalDate localDate);

    @MapKey("id")
    Map<Long,DeptCascade> getDeptCascade();

}
