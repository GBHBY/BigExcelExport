package com.gyb.demo.dao;

import com.gyb.demo.bean.CustomerDept;
import com.gyb.demo.bean.DepartmentDO;
import com.gyb.demo.bean.QYEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    Integer getYestodayLose(@Param("ids") List<Long> value);

    int count(@Param("ids") List<Long> value,@Param("delete") String none,@Param("dis") boolean b);
}
